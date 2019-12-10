import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class ParseTest2 {

    @Test
    public void parseIt() {
        LinkedList<String> ls = null;
        String text = "7.5 h h";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "7.5");

        text = "10,123";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.123K");

        text = "123 Thousand";


        ls = printTest(text);
        assertEquals(ls.getFirst() , "123K");

        text = "1010.56";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "1.01K");

        text = "10,123,000";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.123M");

        text = "55 Million";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "55M");


        text = "10,123,000,000";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.123B");

        text = "55 Billion";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "55B");

        text = "55 3/4";
        ls = printTest(text);
        assertEquals(ls.getLast() , "55 3/4");

        text = "55.87";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "55.87");

        text = "10.6%";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.6%");

        text = "10.6 percentage";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.6%");

        text = "10.6 percent";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.6%");

        text = "1.732 Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "1.732 Dollars");

        text = "22 3/4 Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "22 3/4 Dollars");

        text = "$450,000";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "450,000 Dollars");


        text = "1,000,000 Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "1 M Dollars");

        text = "$450,000,000";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "450 M Dollars");

        text = "$100 million";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "100 M Dollars");

        text = "20.6m Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "20.6 M Dollars");


        text = "20.6 m Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "20.6 M Dollars");

        text = "100 bn Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "100000 M Dollars");

        text = "$100 billion";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "100000 M Dollars");

        text = "100 billion U.S. dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "100000 M Dollars");

        text = "320 million U.S. dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "320 M Dollars");

        text = "4 Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "4 Dollars");

        text = "Hi I win 320 million U.S. dollars in 450,000 loto's " +
                "My wife won 20.6 m Dollars Dollars but actually the Change to win is 9.3 percent 9.3% +"
                +" 9.3 percentage 4$ $4 4 Dollars 320 million dollars"+
                "I paid for the card 17 4/9 4/8 4$ shekels AND for this bullshit 10,123,000,000 55 55 Billion" ;
        ls = printTest(text);
        for (String s:
                ls) {
            System.out.println(s);
        }
        text = "4 Dollars";
        ls = printTest(text);
       assertEquals(ls.getFirst() , "4 Dollars");
       text="123 billion pounds";
       ls=printTest(text);
        assertTrue(ls.contains("123000M pounds"));
        text="14.7 billion pounds";
        ls=printTest(text);
        assertTrue(ls.contains("14700M pounds"));
        text="12.52 billion pounds";
        ls=printTest(text);
        assertTrue(ls.contains("12520M pounds"));
        text="123 million pounds";
        ls=printTest(text);
        assertTrue(ls.contains("123M pounds"));
        text="14.7 million pounds";
        ls=printTest(text);
        assertTrue(ls.contains("14.7M pounds"));
        text="12.52 million pounds";
        ls=printTest(text);
        assertTrue(ls.contains("12.52M pounds"));
        text="123 tons";
        ls=printTest(text);
        assertTrue(ls.contains("246000 pounds"));
        text="14.4 tons";
        ls=printTest(text);
        assertTrue(ls.contains("28800 pounds"));
        text="12.52 tons";
        ls=printTest(text);
        assertTrue(ls.contains("25040 pounds"));
        text="123 feet";
        ls=printTest(text);
        assertTrue(ls.contains("123 feet"));
        text="14.4 feet";
        ls=printTest(text);
        assertTrue(ls.contains("14.4 feet"));
        text="12.52 feet";
        ls=printTest(text);
        assertTrue(ls.contains("12.52 feet"));
        text="123 yards";
        ls=printTest(text);
        assertTrue(ls.contains("369 feet"));
        text="14.4 yards";
        ls=printTest(text);
        assertTrue(ls.contains("43.2 feet"));
        text="12.52 yards";
        ls=printTest(text);
        assertTrue(ls.contains("37.56 feet"));
        text="123 miles";
        ls=printTest(text);
        assertTrue(ls.contains("649440 feet"));
        text="14.4 miles";
        ls=printTest(text);
        assertTrue(ls.contains("76032.0 feet"));
        text="14 May";
        ls=printTest(text);
        assertTrue(ls.contains("05-14"));
        text="14 MAY";
        ls=printTest(text);
        assertTrue(ls.contains("05-14"));
        text="JUNE 04";
        ls=printTest(text);
        assertTrue(ls.contains("06-04"));
        text="June 04";
        ls=printTest(text);
        assertTrue(ls.contains("06-04"));
        text="May 1994";
        ls=printTest(text);
        assertTrue(ls.contains("1994-05"));
        text="May 1994";
        ls=printTest(text);
        assertTrue(ls.contains("1994-05"));


    }
    private LinkedList<String> printTest(String text){
        Parse pr = new Parse("C:\\Users\\Aviel\\corpus");

        Map<String,Integer> l = pr.parseIt(text);
        Iterator<String> it = l.keySet().iterator();
        System.out.println("------------------------------------------------------------");
        LinkedList<String> ls = new LinkedList<>();
        while ( it.hasNext() ) {
            //  System.out.println("next "+l.keys().nextElement() );
            ls.add(it.next());
        }
        return ls;
    }
}