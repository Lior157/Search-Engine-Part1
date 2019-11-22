import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String text= "DIVISION ANALYSIS TEAM, (703)-733-6534.) \n" +
                "<DOCNO> FBIS3-4 </DOCNO>\n" +
                "Article Type:FBIS \n" +
                "Document Type:FOREIGN MEDIA NOTE--FB PN 94-029--ALGERIA words someone's Let It Be s Alton John ";

        Parse test=new Parse();
        test.parseIt(text);
        System.out.println(test.entities);

    }

}
