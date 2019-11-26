import java.io.File;
import java.io.FileReader;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;

public class MainFileCreation {

    public static void main(String[] args) {
//      double num = 1010.56/1000;
//    //  System.out.println(String.format("%.03f",num));
//        DecimalFormat format = new DecimalFormat("0.###");
//        format.setRoundingMode(RoundingMode.DOWN);
//        format.format(num);
//        System.out.println(format.format(num));


//        Dictionary<String , Integer> dc = new Hashtable<>();
//        dc.put("hi" , 1);
//        dc.put("hi" , dc.get("hi")+1);
//        System.out.println(dc.get("hi"));
//        dc.remove("hi");
//        dc.put("HI", 7);
//        dc.put("bI", 37);
//        Enumeration<String> it = dc.keys();
//        while ( it.hasMoreElements() ) {
//            String sr = it.nextElement();
//            System.out.println("next :"+sr + " " + dc.get(sr));
//
//        }
//        System.out.println("------------------------------" );
//        dc.put("hi", 55);
//        it = dc.keys();
//        while ( it.hasMoreElements() ) {
//            String sr = it.nextElement();
//            System.out.println("next :"+sr + " " + dc.get(sr));
//        }

 ///////////////////       1.0
//
//
////
        Parse.TurnOffStem();
        File folder = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\corpus");
        Path p = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1");

        long start = System.currentTimeMillis();
////        ReadFile rf = new ReadFile(p ,folder);
////        rf.run();
////
       int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        System.out.println(cores);
        for(int i=0 ; i< threads.length ;i++) {
            threads[i] = new Thread(new ReadFile(p ,folder));
            threads[i].start();
        }
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        }catch (Exception e) {
        }
         File lo = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\TemporaryFiles");
         File co = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\@Docs_Information.txt");
        Path to = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\PostingFiles");
        Path po = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1");
        Indexer.MergeTemporaryFile( lo,to,co,po);
////
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);

//----------------------------------------------------------------------------------------------------------------- stemmimg
        Parse.TurnOnStem();
        ReadFile.initialazleVariable();
        Indexer.initialazleVariable();
        folder = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\corpus");
        p = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1withstem");



       start = System.currentTimeMillis();
        ReadFile rf = new ReadFile(p ,folder);
        //rf.run();

        Thread[] threads2 = new Thread[cores];
        System.out.println(cores);
        for(int i=0 ; i< threads2.length ;i++) {
            threads2[i] = new Thread(new ReadFile(p ,folder));
            threads2[i].start();
        }
        try {
            for (int i = 0; i < threads2.length; i++) {
                threads2[i].join();
            }
        }catch (Exception e) { System.out.println(e);
        }
          lo = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\TemporaryFiles");
          co = new File("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\@Docs_Information.txt");
         to = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1\\PostingFiles");
         po = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\test1withstem");
        Indexer.MergeTemporaryFile( lo,to,co,po);

         finish = System.currentTimeMillis();
         timeElapsed = finish - start;
        System.out.println(timeElapsed);


    }



}
