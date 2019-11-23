import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String text= "POLITICIANS,  PARTY PREFERENCES \n" +
                "\n" +
                "   Summary:  Newspapers in good good good good the Former good Yugoslav Republic of \n" +

                "\n" +
                "ELAG/25 February/POLCHF/EED/DEW 28/2023Z FEB";

        Parse test=new Parse();
        test.parseIt(text);
        System.out.println(test.entities);

    }

}
