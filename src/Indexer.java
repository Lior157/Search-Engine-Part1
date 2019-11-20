import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Indexer {
    private Map<String , Map<Integer,Integer>> Voc ;
    private LinkedList<String> fileMeta_data;
    private int fileIteration ;
    private static volatile Object lookIncrease  = new Object();
    private static volatile Integer fileNumber = 1 ;
    private Parse parser;
    private Path pathData ;
    private LinkedList<String>[] AB_words;
    private static volatile Object[] AB_wordsLook = clearLookArray();
    private static volatile Object lookWriteDocsInformationFile = new Object();

    public Indexer(Path path){
        parser =new Parse();
        this.pathData=path;
        fileIteration=0;
        AB_words = new LinkedList[27];
        clearLinkedListArray();
        fileMeta_data = new LinkedList<>();
        Voc = new HashMap<>();
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
            fileMeta_data.add(local_file_num + "=" + title.text() + "|" + date.text() + "|" + docno.text() + "|max_tf|" + max_tf + "|qw|" + mp.size());
            fileIteration++;
            //   System.out.println(fileIteration);
            ManageWritingInformation(local_file_num ,false);
        }
    }
    private void ManageWritingInformation(int local_file_num,boolean endWriting){
//        if(endWriting) {
//            System.out.println(fileNumber);
//        }else{
//            System.out.println(local_file_num);
//        }

            if(fileIteration>=1000 || endWriting){
                System.out.println(local_file_num);
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
                        AB_words[((int)letter)-97].add(term+"="+Voc.get(term).toString());
                    }else{
                        AB_words[26].add(term+"="+Voc.get(term).toString()+"\n");
                    }
                }
                fileIteration = 0 ;
                writeFile();
                Voc = new HashMap<>();


            }
        }
    public void writeFile(){
        String st ;
        int index =0;
        for (LinkedList<String> terms:
            AB_words ) {

            if(index == 26){
                st = this.pathData.toString() + "//number&sign";
            }else{
                st = this.pathData.toString() + "//@"  + ((char)(index+97));
            }
            Path p = Paths.get(st);
            String listString = String.join("\n", terms);
            byte data[] = listString.getBytes();
            synchronized (AB_wordsLook[index]) {
                try (OutputStream out = new BufferedOutputStream(
                        Files.newOutputStream(p, CREATE, APPEND))) {
                    out.write(data, 0, data.length);
                } catch (IOException x) {
                    System.err.println(x);
                }
            }
            index++;
        }
        clearLinkedListArray();

        st = this.pathData.toString() + "//@Docs_Information" ;
        Path p = Paths.get(st);
        String listString = String.join("\n", fileMeta_data);
        byte data[] = listString.getBytes();
        synchronized (lookWriteDocsInformationFile) {
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
