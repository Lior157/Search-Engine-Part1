
import javafx.util.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Indexer {
    private Map<String , Map<Integer,Integer>> Voc ;
    private LinkedList<String> fileMeta_data;
    private int fileIteration ;
    private static volatile Object lookIncrease  = new Object();
    private static volatile Integer fileNumber = 1 ;
    private Parse parser;
    private  static volatile Path pathData ;
    private LinkedList<Pair<String,String>>[] AB_words;
//    private static volatile Object[] AB_wordsLook = clearLookArray();
    private static volatile Object lookWriteDocsInformationFile = new Object();
    private static volatile Integer writingId = 1 ;
    private static volatile Object lookIncreaseWritingId  = new Object();
    private static volatile Path[] pathsTemporaryFiles;
    private static volatile boolean  pathesTemporaryFilesExist = false;

    public static void initialazleVariable(){
        lookIncrease  = new Object();
        fileNumber = 1 ;
        lookWriteDocsInformationFile = new Object();
        writingId = 1 ;
        lookIncreaseWritingId  = new Object();
        pathesTemporaryFilesExist = false;
    }

    public Indexer(Path path){
        parser =new Parse();
        this.pathData=path;
        fileIteration=0;
        AB_words = new LinkedList[27];
        clearLinkedListArray();
        fileMeta_data = new LinkedList<>();
        Voc = new HashMap<>();
    }

    private Path[] PathesTemporaryFiles(){
        Path[] pathes  = new Path[27];
        String st;
        new File("TemporaryFiles").mkdirs();
    //    System.out.println("e: ");
        for (int i=0 ; i<27 ; i++){
            if(i == 26){
                st = pathData.toString() + "//TemporaryFiles//number&sign";
            }else{
                st = pathData.toString() + "//TemporaryFiles//"  + ((char)(i+97));
            }
            pathes[i] = Paths.get(st);
            new File(pathes[i].toString()).mkdirs();
            System.out.println("e: "+pathes[i].toString());
        }
        return pathes;
    }

    private void clearLinkedListArray(){
        for ( int i=0 ; i<AB_words.length ;i++){
            AB_words[i] = new LinkedList();
        }
    }

    private static Object[] clearLookArray(){
        Object[] AB_wordsLook = new Object[27];
        for ( int i=0 ; i<AB_wordsLook.length ;i++){
            AB_wordsLook[i] = new Object();
        }
        return AB_wordsLook;
    }

    public void WriteData(Elements All_docs ,boolean endWriting) {
        if(endWriting){
            ManageWritingInformation( 0 , endWriting);
            return;
        }

        for (Element doc :
                All_docs) {
            Integer local_file_num;
            synchronized (lookIncrease) {
                local_file_num = fileNumber;
                fileNumber++;
             //   System.out.println("local:"+local_file_num);
            }
            Elements title = doc.getElementsByTag("TI");
            Elements date = doc.getElementsByTag("DATE1");
            Elements docno = doc.getElementsByTag("DOCNO");

            Map<String, Integer> mp = parser.parseIt(doc.text());

            int max_tf = 0;
            String[] it = mp.keySet().toArray(new String[mp.size()]);

            for (String s :
                    it) {
                if (Voc.get(s) == null) {
                    Map<Integer, Integer> l = new HashMap<>();
                    Voc.put(s, l);
                }
                Voc.get(s).put(local_file_num, mp.get(s));
                if (mp.get(s) > max_tf) {
                    max_tf = mp.get(s);
                }
            }
           // System.out.println(local_file_num + "=" + title.text() + "|" + date.text() + "|" + docno.text() + "|max_tf|" + max_tf + "|qw|" + mp.size());
            fileMeta_data.add(local_file_num + "=" + title.text() + "|" + date.text() + "|" + docno.text() + "|max_tf|" + max_tf + "|qw|" + mp.size());
         //   System.out.println("local add:"+local_file_num);
            fileIteration++;
            //   System.out.println(fileIteration);
            ManageWritingInformation(local_file_num ,false);
        }
    }
    private void ManageWritingInformation(int local_file_num,boolean endWriting){

            if(fileIteration>=10000 || endWriting){
              //  System.out.println(local_file_num);
                String[] voc = Voc.keySet().toArray(new String[Voc.size()]);
                for (String term:
                        voc) {
                //    System.out.println(term);
                    if(term == null || term.length()<1) {
                        continue;
                    }
                    char letter = term.charAt(0);
                    if( letter>= 65 && letter<=90){
                        letter =  (char)(((int )letter)+32) ;
                    }
                    if(letter>= 97 && letter<=122){
                        AB_words[((int)letter)-97].add(new Pair<>(term , Voc.get(term).toString()));
                    }else{
                        AB_words[26].add(new Pair<>(term , Voc.get(term).toString()));
                    }
                }
                fileIteration = 0 ;
                writePostingFile();
                Voc = new HashMap<>();


            }
        }

    public static void MergeTemporaryFile(File folder  , Path mergedFilesFolder ,File fileIndexing, Path pathForAllDictionary){
        new File(mergedFilesFolder.toString()).mkdirs();
        System.out.println("size:"+folder.listFiles().length);
        ExecutorService tpex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()/2);
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.isDirectory()){
                System.out.println("path:" + fileEntry.getPath());
                if(fileEntry.getName().length() > 1){
                    Thread t = new Thread(new IndexerMerging(fileEntry , 26 , mergedFilesFolder,pathForAllDictionary));
                    tpex.execute(t);
                 //   t.start();
                }else {
                    int firstNumberOfName = (int) fileEntry.getName().charAt(0);
                    System.out.println(firstNumberOfName);
                    if (firstNumberOfName >= 97 && firstNumberOfName <= 122) {
                        Thread t = new Thread(new IndexerMerging(fileEntry, firstNumberOfName - 97, mergedFilesFolder,pathForAllDictionary));
                        //  t.start();
                        tpex.execute(t);
                        //   tpex.submit(new IndexerMerging(fileEntry , 26 , mergedFilesFolder));
                    }
                }
            }
        }
        SortIndexingToFiles(fileIndexing);
        tpex.shutdown();
        while (!tpex.isTerminated()){
            Thread.yield();
        }
        IndexerMerging.summaryAllDictionaryWords(pathForAllDictionary);
        System.out.println("finished");
    }

    public static void SortIndexingToFiles(File file){
        try {
            String text = new String(Files.readAllBytes(file.toPath()));
            String[] splitedLinesInput = text.split("\n");
            System.out.println(splitedLinesInput.length);
            String[] output = new String[splitedLinesInput.length] ;
            for (int i = 0 ; i < splitedLinesInput.length ; i++){
                try {
                    int indexOfFile = Integer.parseInt(splitedLinesInput[i].substring(0,splitedLinesInput[i].indexOf("=")));
                    output[indexOfFile-1] = splitedLinesInput[i];
                }catch (Exception e){

                    System.out.println("SortIndexingToFiles error " +splitedLinesInput[i]+" |"+e+"|"+i);
                }
            }

            Path pathForSaving = Paths.get(file.toString().substring(0,file.toString().indexOf("."))+"Analayzed.txt");
            String listString = String.join("\n", output );
            byte data[] = listString.getBytes();

            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(pathForSaving, CREATE))) {
                out.write(data, 0, data.length);
            } catch (IOException x) {
                System.err.println(x);
            }

        }catch (IOException x) {
            System.err.println(x);
        }
    }


    public void writePostingFile(){
        if(! pathesTemporaryFilesExist){
            synchronized (lookIncreaseWritingId) {
                if (! pathesTemporaryFilesExist){
                    pathesTemporaryFilesExist = true;
                    pathsTemporaryFiles = PathesTemporaryFiles();
                }
            }
        }
        String st ;
        int index =0;
        for (LinkedList<Pair<String,String>> terms:
            AB_words ) {
            int numberOfWriting = 0 ;
            synchronized (lookIncreaseWritingId){
                numberOfWriting = writingId;
                writingId++;
            }

            String path = pathsTemporaryFiles[index].toString()+"//"+numberOfWriting;
            System.out.println(path);

            try {
                FileOutputStream f = new FileOutputStream(new File(path));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(AB_words[index]);
                o.close();
            }catch (Exception e){ }

           index++;
        }
        clearLinkedListArray();

        st = this.pathData.toString() + "//@Docs_Information.txt" ;
        Path p = Paths.get(st);
        String listString = String.join("\n", fileMeta_data)+"\n";

        byte data[] = listString.getBytes();
        synchronized (lookWriteDocsInformationFile) {
         //   System.out.println("------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+listString.substring(0,5));
            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(p, CREATE, APPEND))) {
                out.write(data, 0, data.length);
            } catch (IOException x) {
                System.err.println(x);
            }
        }
        fileMeta_data = new LinkedList<>();
    }
}
