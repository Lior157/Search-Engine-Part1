import javafx.util.Pair;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

import static java.nio.file.StandardOpenOption.CREATE;

public class IndexerMerging implements Runnable {
    private final File folder;
    private int index ;
    private final Path mergedFilesFolder;

    public IndexerMerging(File folder, int index, Path mergedFilesFolder) {
        this.folder = folder;
        this.index = index;
        this.mergedFilesFolder = mergedFilesFolder;
    }

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
            TreeSet<String> sortedMap = new TreeSet<>(mergedFile.keySet());
            String st;
            StringBuilder content = new StringBuilder();
            String[] it = sortedMap.toArray(new String[mergedFile.size()]);
            for (String key:
                    it ) {
                content.append(key+" = "+"|df="+mergedFile.get(key).size()+"|"+mergedFile.get(key).toString()+"\n");
            }

            if(index == 26){
                st = mergedFilesFolder.toString() + "//number&sign";
            }else{
                st = mergedFilesFolder.toString() + "//@"  + ((char)(index+97));
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
//            synchronized (AB_wordsLook[index]) {
//
//            }
        }catch (Exception e){ System.err.println(e);}
    }

    @Override
    public void run() {
        MergeTemporaryFile();
    }
}
