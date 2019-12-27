import javafx.beans.binding.StringBinding;
import javafx.util.Pair;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/***
 * this class rensponsiable for taking a temporary files and sort & merge them to posing files
 */
public class IndexerMerging implements Runnable {
    private final File folder;
    private int index ;
    private final Path mergedFilesFolder;
    private final Path pathForDictionary;
    private static volatile Integer numberOfQniqueTerms;
    private static Object lookForNumberOfQniqueTerms=new Object();
    private static LinkedList<String>[] entities;

    public IndexerMerging(File folder, int index, Path mergedFilesFolder, Path pathForDictionary) {
        this.folder = folder;
        this.index = index;
        this.mergedFilesFolder = mergedFilesFolder;
        this.pathForDictionary = pathForDictionary;
    }
    /**
     * initialaze static variables
     */
    public static void initialazleVariable(){
        lookForNumberOfQniqueTerms=new Object();
        numberOfQniqueTerms=0;
        entities = new LinkedList[472525];
        for (int i=0; i < entities.length ; i++){
            entities[i] = new LinkedList<>();
        }
    }
    /**
     * merging the temporary files to posting files
     */
    public void MergeTemporaryFile(){
        try {
            Map<String, LinkedList<String>> mergedFile = new HashMap<>();
            for (final File fileEntry : folder.listFiles()) {
                if (!fileEntry.isDirectory()) {
                    FileInputStream fi = new FileInputStream(fileEntry);
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    LinkedList<Pair<String, String>> pr1 = (LinkedList<Pair<String, String>>) oi.readObject();
                    for (Pair<String, String> pair :
                            pr1) {
                        if (!mergedFile.containsKey(pair.getKey())) {
                            mergedFile.put(pair.getKey(), new LinkedList<String>());
                        }
                        mergedFile.get(pair.getKey()).add(pair.getValue());
                    }
                }
            }
            // Map<String, LinkedList<String>> sortedMap = new TreeMap<String, LinkedList<String>>(mergedFile);
            List<String> sortedMap = new ArrayList<String>(mergedFile.keySet());
            Collections.sort(sortedMap, String.CASE_INSENSITIVE_ORDER);
            //TreeSet<String> sortedMap = new TreeSet<>(mergedFile.keySet());
            String st;
            StringBuilder content = new StringBuilder();
            StringBuilder allVoc = new StringBuilder();
          //  String[] it = sortedMap.toArray(new String[mergedFile.size()]);
            int tempNumberOfQnique=0;
            for (int i=0; i<sortedMap.size();i++ ) {
                String key = sortedMap.get(i);
                String[] terms = key.split(" ") ;
                if(terms.length>1 ){
                    boolean isEntity = true;
                    for(String word : terms ){
                        if( !( word.charAt(0)>= 65 && word.charAt(0)<=90) ){
                            isEntity=false;
                        }
                    }
                    if( isEntity && mergedFile.get(key).size()<2 ){
                        continue;
                    }
                    if(isEntity){

                        String[] appearence = mergedFile.get(key).toString().split("[ \\,\\}\\{\\]\\[]+");
                        for(String wordAppear : appearence ){
                            if(wordAppear.contains("=")){
                                int index = wordAppear.indexOf("=");
                                int DocID = Integer.parseInt(wordAppear.substring(0,index));
                                entities[DocID-1].add(key+"="+wordAppear.substring(index+1));
                            }
                        }
                    }
                }
                LinkedList<String> listOfTermAppearence;
                if(( i<sortedMap.size()-1 )&& key.toLowerCase().equals(sortedMap.get(i+1).toLowerCase())){
                    String key2 = sortedMap.get(i+1);
                    int size = mergedFile.get(key).toString().split("=").length +
                            mergedFile.get(key2).toString().split("=").length-2 ;
                    String list = mergedFile.get(key).toString()+mergedFile.get(key2).toString();
                    content.append(key.toLowerCase() + " = " + "|df=" + size + "|" + list+ "\n");
                    i++;
                    listOfTermAppearence = mergedFile.get(key);
                    listOfTermAppearence.addAll(mergedFile.get(key2));
                    key = key.toLowerCase();
                }else {
                    int size = mergedFile.get(key).toString().split("=").length-1;
                    content.append(key + " = " + "|df=" + size + "|" + mergedFile.get(key).toString() + "\n");
                    listOfTermAppearence = mergedFile.get(key);
                }
                int number_of_appearence = 0;
                for(String appear : listOfTermAppearence){
                    String[] pairs = appear.split(",");
                    for (String pair:
                         pairs) {

                        int startIndex = pair.indexOf("=");
                        String frequncy = pair.substring(startIndex+1);
                        if(frequncy.endsWith("}")){
                            frequncy = pair.substring(startIndex+1 , pair.length()-1);
                        }
                     //   System.out.println(pair+":::"+frequncy);
                        number_of_appearence=number_of_appearence+Integer.parseInt(frequncy);
                    }

                }

                allVoc.append(key+"="+number_of_appearence+"\n");
                tempNumberOfQnique++;
            }
            synchronized (lookForNumberOfQniqueTerms){
                numberOfQniqueTerms=numberOfQniqueTerms+tempNumberOfQnique;
            }
            if(index == 26){
                st = mergedFilesFolder.toString() + "//number&sign.txt";
            }else{
                st = mergedFilesFolder.toString() + "//@"  + ((char)(index+97)+".txt");
            }
            Path p = Paths.get(st);
          //
            //  System.out.println(p);
            byte data[] = content.toString().getBytes();
            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(p, CREATE))) {
                out.write(data, 0, data.length);
                out.flush();
            } catch (IOException x) {
                System.err.println(x);
            }

            Path p2 = Paths.get(pathForDictionary+"//dictionary-"+((char)(index+97))+".txt");
            byte allVocInBytes[] = allVoc.toString().getBytes();
            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(p2, CREATE))) {
                out.write(allVocInBytes, 0, allVocInBytes.length);
                out.flush();
            } catch (IOException x) {
                System.err.println(x);
            }
        }catch (Exception e){ System.err.println(e);}
    }

    /**
     * merge all dictionaries to one big one.
     * @param pathForDictionary - path for folder that contains all small dictionaries
     * @param pathForAllDictionaryWithFileName- path for new one big dictionary
     */
    public static void summaryAllDictionaryWords(Path pathForDictionary , Path pathForAllDictionaryWithFileName ,Path mergedFilesFolder){

        for(int i=0 ; i<27 ;i++){

            byte[] array = new byte[0];
            try {
                FileInputStream fi;
                File fileEntry = new File(pathForDictionary + "//dictionary-" + ((char) (i + 97)) + ".txt");
                fi = new FileInputStream(fileEntry);
                array = new byte[(int) fileEntry.length()];
                fi.read( array );
                fi.close();
            }catch(Exception e){System.out.println(e);}


            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(pathForAllDictionaryWithFileName , CREATE,APPEND))) {
                out.write(array, 0, array.length);
                out.flush();
            } catch (IOException x) {
                System.err.println(x);
            }
        }
        StringBuilder entitiesString  = new StringBuilder();
        for(int i=0 ; i < entities.length ; i++){
            entitiesString.append((i+1)+"="+entities[i].toString()+"\n");
        }
        Path entitiesPath = Paths.get( mergedFilesFolder.toString()+"\\DocToEntities.txt");
        byte data[] = entitiesString.toString().getBytes();
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(entitiesPath , CREATE,APPEND))) {
            out.write(data, 0, data.length);
            out.flush();
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    /**
     *
     * @return number of qniqueTerms
     */
    public static Integer NumberOfQniqueTerms(){
        return numberOfQniqueTerms;
    }
    @Override
    public void run() {
        MergeTemporaryFile();
    }
}
