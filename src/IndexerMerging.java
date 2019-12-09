import javafx.util.Pair;

import java.io.*;
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

    public IndexerMerging(File folder, int index, Path mergedFilesFolder, Path pathForDictionary) {
        this.folder = folder;
        this.index = index;
        this.mergedFilesFolder = mergedFilesFolder;
        this.pathForDictionary = pathForDictionary;
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
            for (String key:
                    sortedMap ) {
                content.append(key+" = "+"|df="+mergedFile.get(key).size()+"|"+mergedFile.get(key).toString()+"\n");

                allVoc.append(key+"="+mergedFile.get(key).size()+"\n");
            }

            if(index == 26){
                st = mergedFilesFolder.toString() + "//number&sign.txt";
            }else{
                st = mergedFilesFolder.toString() + "//@"  + ((char)(index+97)+".txt");
            }
            Path p = Paths.get(st);
            System.out.println(p);
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
    public static void summaryAllDictionaryWords(Path pathForDictionary , Path pathForAllDictionaryWithFileName){

        for(int i=0 ; i<27 ;i++){
            FileInputStream fi;
            byte[] array = new byte[0];
            try {

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


    }
    @Override
    public void run() {
        MergeTemporaryFile();
    }
}
