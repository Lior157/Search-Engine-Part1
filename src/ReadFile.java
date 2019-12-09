import javafx.util.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.awt.Mutex;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ReadFile implements Runnable{

    private Path pathData;

    private File folder ;
    private static volatile ConcurrentHashMap<String,Integer> filesExecuted = new ConcurrentHashMap<>();
    private static volatile Object lookClean  = new Object();
    private static volatile boolean cleanfile = true;
    private Indexer ind ;
    private static String corpusPath;


    /**
     * @param corpus The path to the corpus folder
     * This function initializes the static variables of the class
     */
    public static void initialazleVariable(String corpus){
        filesExecuted = new ConcurrentHashMap<>();
        lookClean = new Object();
        cleanfile=true;
        corpusPath=corpus;
    }

    /**
     * @param pathData The path to the dictionary location folder
     * @param folder
     * This constructor initializes and object
     */
    public ReadFile(Path pathData , final File folder) {
            synchronized (lookClean) {
                if (cleanfile) {
                    cleanfile = false;
                    if (Files.exists(pathData)) {
                        // file exist
                        System.out.println("exist");
                        deleteDirectory(new File(pathData.toString()));
                    }

                }

            }
        new File(pathData.toString()).mkdirs();
        this.pathData = pathData;
        this.folder = folder;
    }

    /**
     * @param directoryToBeDeleted The path to the directory
     * @return Boolean that represents success of the deletion
     * This function deletes all the contents of the given path
     */
    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    /**
     * @param folder The dictionary wanted folder
     * This function lists the files that the class reads
     */
    private void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                boolean check = false ;
                synchronized (lookClean) {
                    if (!filesExecuted.containsKey(fileEntry.toPath().toString())) {
                        filesExecuted.put(fileEntry.toPath().toString(),0);
                        check = true ;
                    }
                }
                if(check) {
                    readFile(fileEntry.toPath());
                }
            }
        }
    }

    /**
     * @param file The path to the file that needs reading
     * This function reads the file and writes his data
     */
    public void readFile(Path file) {


        try {
                  Document document = Jsoup.parse(new String(Files.readAllBytes(file)));
                  Elements All_docs =  document.getElementsByTag("DOC");
                  ind.WriteData(All_docs , false);

        }catch (IOException x) {
            System.err.println(x);
        }
//            while ((line = reader.readLine()) != null) {
//               // System.out.println(line);
//                text=text+line;
//                if(line.startsWith("</DOC>")){
//                    writeFile(text ,fileName);
//                    text="";
//                }else{
//                    text=text+"\n";
//                }
//            }
//        } catch (IOException x) {
//            System.err.println(x);
//        }
    }



    @Override
    public void run() {
       this.ind = new Indexer(pathData,corpusPath);
        listFilesForFolder(folder);
        ind.WriteData(null , true);
    }
}
