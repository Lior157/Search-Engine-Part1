import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.nio.file.StandardOpenOption.CREATE;

public class parseAllDocs implements Runnable {

    private volatile Path pathData;
    private Parse parser;
    private static volatile Map<String ,Integer> totalVoc;
    private volatile HashSet<String> filesExecuted ;
    private volatile Object lookIncrease;

    public parseAllDocs(Path pathData ) {
        new File(pathData.toString()).mkdirs();
        this.pathData = pathData;
        parser = new Parse();
        totalVoc = new ConcurrentHashMap<>();
        this.filesExecuted = new HashSet<>();
        lookIncrease = new Object();
    }


    public void startParseVoc(){

        startParseVoc(new File(pathData.toString()));
      //  sumUpData();
    }
    private void startParseVoc(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                startParseVoc(fileEntry);
            } else {
                boolean check = false ;
                synchronized (this) {
                    if (!filesExecuted.contains(fileEntry.toPath().toString())) {
                        filesExecuted.add(fileEntry.toPath().toString());
                        check = true ;
                    }
                }
                if(check) {
                    readFile(fileEntry.toPath() , fileEntry.getPath() );
                }

            }
        }
    }

    public void readFile(Path file ,String filePath) {
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            StringBuilder text = new StringBuilder();
            String line="" ;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                text=text.append(line);
                if(line.startsWith("</TEXT>")){
                    writeFile(text.toString() ,filePath);
                    text.delete(0, text.length());
                }else if(line.startsWith("<TEXT>")){
                    text.delete(0, text.length());
                    System.out.println("text :"+text);
                }else{
                    text=text.append("\n");
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public void writeFile(String text , String filePath){

    //    new File(pathData.toString()+"//@"+fileNumber).mkdirs();
        String st = filePath +"@Vocabulary";
        System.out.println(st);
        String Vtext = this.ParseText(text);
        byte data[] = Vtext.getBytes();
        Path p = Paths.get(st);
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    private String ParseText(String text){
        StringBuilder Vtext = new StringBuilder();
        try {
            Map<String, Integer> l = parser.parseIt(text);
            Iterator<String> it = l.keySet().iterator();

            while (it.hasNext()) {
                synchronized (lookIncrease) {
                    String key = it.next();
                    Vtext.append(key + " &->& " + l.get(key) + "\n");
                    Integer sum = l.get(key);
                    if (totalVoc.containsKey(key)) {
                        sum = sum + totalVoc.get(key);
                        System.out.println("sum : " + sum);
                    }
                    totalVoc.put(key, sum);
            }

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return Vtext.toString();
    }

    public  void sumUpData (){
        String st = this.pathData.toString() +"@All_Vocabulary";
        System.out.println(st);

        Iterator<String> it = totalVoc.keySet().iterator();
        StringBuilder Vtext = new StringBuilder();
        while ( it.hasNext() ) {
            String key = it.next();
            Vtext.append(key+" &->& "+totalVoc.get(key)+"\n");
        }

        byte data[] = Vtext.toString().getBytes();
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
        startParseVoc();
    }
}
