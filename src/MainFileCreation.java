import java.io.File;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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


//        final File folder = new File("D://מסמכים//לימודים//שנה ג//איחזור//corpus");
//        Path p = Paths.get("D://מסמכים//לימודים//שנה ג//איחזור//test5");
//        ReadFile rf = new ReadFile(p ,folder );
//        rf.listFilesForFolder(folder);
//        //// 2.0
//        parseAllDocs pd= new parseAllDocs(p);
//        pd.startParseVoc();



       final File folder = new File("D://מסמכים//לימודים//שנה ג//איחזור//corpus");
        Path p = Paths.get("D://מסמכים//לימודים//שנה ג//איחזור//test894");
        ReadFile rf = new ReadFile(p ,folder);
       // rf.run();
//
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        System.out.println(cores);
        for(int i=0 ; i< threads.length ;i++) {
            threads[i] = new Thread(rf);
            threads[i].start();
        }
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        }catch (Exception e) {
        }
            //// 2.0
//            parseAllDocs pd =  new parseAllDocs(p);
//            Thread[] threads2 = new Thread[cores];
//            for(int i=0 ; i< threads2.length ;i++) {
//                threads2[i] = new Thread(pd);
//                threads2[i].start();
//            }
//            for (int i = 0; i < threads2.length; i++) {
//                threads2[i].join();
//            }
//            pd.sumUpData();
//        }catch (Exception e){
//
//        }



    }



}
