import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class ParseTest2 {

    @Test
    public void parseIt() {
        LinkedList<String> ls = null;
        String text = "10.23 h h";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "10.23");

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
        //  assertEquals(ls.getFirst() , "450,000 Dollars");


        text = "1,000,000 Dollars";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "1 M Dollars");

        text = "$450,000,000";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "450 M Dollars");

        text = "$100 million";
        ls = printTest(text);
        assertEquals(ls.getFirst() , "100 M Dollars");

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
    }
    private LinkedList<String> printTest(String text){
        Parse pr = new Parse();

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