import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ReadFile implements Runnable{

    private Path pathData;
    private volatile Integer fileNumber ;
    private Parse parser;
    private File folder ;
    private volatile HashSet<String> filesExecuted ;
    private volatile Object lookIncrease;

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
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            String text="" ;
            while ((line = reader.readLine()) != null) {
               // System.out.println(line);
                text=text+line;
                if(line.startsWith("</DOC>")){
                    writeFile(text ,fileName);
                    text="";
                }else{
                    text=text+"\n";
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public void writeFile(String s , String filename){
        byte data[] = s.getBytes();
        String st ;
        synchronized (lookIncrease) {
            fileNumber++;
            new File(pathData.toString() + "//@" + fileNumber).mkdirs();
            st = this.pathData.toString() + "//@" + fileNumber + "//" + filename;
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
        listFilesForFolder(folder);
    }
}
