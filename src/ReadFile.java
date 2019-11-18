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

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ReadFile implements Runnable{

    private Path pathData;
    private volatile Integer fileNumber ;
    private Parse parser;
    private File folder ;
    private volatile HashSet<String> filesExecuted ;
    private volatile Object lookIncrease;
    private Map<String , Map<Integer,Integer>> Voc ;
    private Map<Integer , String> fileMeta_data;
    private int fileIteration ;

    public ReadFile(Path pathData , final File folder) {
        if (Files.exists(pathData)) {
            // file exist
            System.out.println("exist");
            deleteDirectory(new File(pathData.toString()));
        }

        new File(pathData.toString()).mkdirs();
        this.pathData = pathData;
        fileNumber=0;
        this.folder=folder;
        this.filesExecuted = new HashSet<>();
        lookIncrease = new Object();
    }

    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                boolean check = false ;
                synchronized (this) {
                    if (!filesExecuted.contains(fileEntry.toString())) {
                        filesExecuted.add(fileEntry.toString());
                        check = true ;
                    }
                }
                if(check) {
                    readFile(fileEntry.toPath(), fileEntry.getName());
                }
            //    System.out.println(fileEntry.getName());
            }
        }
    }

    public void readFile(Path file ,String fileName) {
//        try (InputStream in = Files.newInputStream(file);
//             BufferedReader reader =
//                     new BufferedReader(new InputStreamReader(in))) {
//            String line = null;
//            String text="" ;
        Voc = new HashMap<>();
        try {
                  Document document = Jsoup.parse(new String(Files.readAllBytes(file)));
                  Elements All_docs =  document.getElementsByTag("DOC");
            fileMeta_data = new HashMap<>();
            for (Element doc:
                 All_docs) {
                Integer local_file_num;
                synchronized (lookIncrease) {
                    local_file_num = fileNumber;
                    fileNumber++;
                }
                Elements title =  doc.getElementsByTag("TI");
                Elements date =  doc.getElementsByTag("DATE1");
                Elements docno =  doc.getElementsByTag("DOCNO");
                fileMeta_data.put(local_file_num , "="+title.text()+"="+date.text()+"="+docno.text());

                Map<String,Integer> mp = parser.parseIt(doc.text());
                Iterator<String> it = mp.keySet().iterator();
                while (it.hasNext()){
                    String s = it.next();
                    if(Voc.get(s)==null){
                        Map<Integer,Integer>  l= new HashMap<>();
                        Voc.put(s , l);
                    }
                    Voc.get(s).put(local_file_num , mp.get(s));
                }
                fileIteration++;
                if(fileIteration>1000){
                    fileIteration = 0 ;
                    writeFile(fileMeta_data.toString() , local_file_num.toString());
                    writeFile(Voc.toString() , local_file_num.toString()+"Voc");
                    fileMeta_data = new HashMap<>();
                    Voc = new HashMap<>();
                }
            }

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

    public void writeFile(String s , String filename){
        byte data[] = s.getBytes();
        String st ;
        synchronized (lookIncrease) {
         //   new File(pathData.toString() + "//@" + fileNumber).mkdirs();
            st = this.pathData.toString() + "//@"  + filename;
        }
        System.out.println(st);
        Path p = Paths.get(st);
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @Override
    public void run() {
        parser = new Parse();
        listFilesForFolder(folder);
    }
}
