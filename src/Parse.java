import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Parse {
    private Map<String,Integer> DATA ;
    private ArrayList<String> text; //List of document words without stop words or blank spaces.
    private HashSet<String> stopWords;
    private int indexDoc ;
    public Parse(){

    }

    public Map<String,Integer> parseIt(String text){

        /*run on each file text - remove stop words ,parse it(and increases number of appearances), stems it , data analysis(the term with the most appearances,number of all terms,*/
        String[] str2 = text.split("[ \"\\t?!\\r?\\n]+");
        this.text = new ArrayList<String>();
        DATA = new Hashtable<>();
        add_stopWords();
        for(int i=0 ; i<str2.length ;i++) {
            if(str2[i].equals("U.S.")) {
                this.text.add(str2[i]);
                continue;
            }
            if(stopWords.contains(str2[i]))
                continue;
            str2[i]=StemWord(str2[i]);
            if(str2[i].startsWith("(")||str2[i].startsWith("*"))
                str2[i]=str2[i].substring(1);
            while(str2[i].endsWith("!")||str2[i].endsWith("?")||str2[i].endsWith(".")||str2[i].endsWith(",")||str2[i].endsWith(":")||str2[i].endsWith(";")||str2[i].endsWith(")")||str2[i].endsWith("*")||str2[i].endsWith("-"))
                str2[i]=str2[i].substring(0,str2[i].length()-2); // changed from -1
            if(str2[i].length()==0)
                continue;
            this.text.add(str2[i]);
        }

        for(indexDoc=0 ; indexDoc< str2.length ;indexDoc++){
            String str;
            str=IsRange(indexDoc);
            if(str!=null){
                AddToData(str,false);
                continue;
            }
            str=isBetween(indexDoc);
            if(str!=null){
                AddToData(str,false);
                continue;
            }
            if(checkIfTermHasConnectionToNumber(indexDoc)!=null){
                str=getNumber(indexDoc);
                AddToData(str,true);
                continue;
            }
            AddToData(getFromText(indexDoc),false);
        }
        for (String key:DATA.keySet()) {
           // System.out.println(key);
            System.out.println(DATA.get(key));
        }
        return DATA;
    }
    private void TextToTerms(String text){

    }
    private void add_stopWords(){
        stopWords=new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("StopWords.txt"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                stopWords.add(line);
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", "StopWords.txt");
            e.printStackTrace();
        }
    }

    private String StemWord(String word){
        Stemmer stemmer=new Stemmer();
        stemmer.add(word.toCharArray(),word.length());
        stemmer.stem();
        StringBuilder ans = new StringBuilder(); // fixed
        for (int i = 0; i <stemmer.getResultBuffer().length; i++) {
            if(stemmer.getResultBuffer()[i] == 0) break;
            ans.append(stemmer.getResultBuffer()[i]);
        }
        System.out.println(ans+" "+word);
        return ans.toString();
    }
    private void AddToData(String word,boolean number){
        if(word.equals(" ")|| word.length()==0){
            return;
        }
        if(number) {
            if (DATA.get(word) != null)
                DATA.put(word, DATA.get(word) + 1);
            else
                DATA.put(word, 1);
            return;
        }
        String upper=word.toUpperCase();
        String lower=word.toLowerCase();
        boolean StartsWithUpper=Character.isUpperCase(word.charAt(0));
        if(DATA.get(upper)!=null){
            if(StartsWithUpper)
            DATA.put(upper,DATA.get(upper)+1);
            else {
                DATA.put(lower, DATA.get(upper) + 1);
                DATA.remove(upper);
            }
        }
        else if(DATA.get(lower)!=null)
            DATA.put(lower,DATA.get(lower)+1);
        else if(StartsWithUpper)
            DATA.put(upper,1);
        else
            DATA.put(lower,1);
        }


    private String getNumber(int index) {
        String str;

        str = this.IsPercent(indexDoc);
        if (str != null)
            return str;

        str = this.IsPrice(indexDoc);
        if (str != null)
            return str;

        str = this.IsNumber(indexDoc);
        if (str != null)
            return str;

        return null;
    }
    private String IsRange(int indexDoc){
        String[]words=getFromText(indexDoc).split("-");
        String number=null;
        if (words.length==1)
            return null;
        else if(words.length==3)
            return words[0]+"-"+words[1]+"-"+words[2];
        else if(words.length==2){
            text.add(indexDoc,words[0]);
            text.add(indexDoc+1,words[1]);
            String ans1=words[0],ans2=words[1];
            if(checkIfTermHasConnectionToNumber(indexDoc)!=null)
                ans1=getNumber(indexDoc);
            if(checkIfTermHasConnectionToNumber(indexDoc+1)!=null)
                ans2=getNumber(indexDoc+1);
            this.indexDoc+=2;
            return ans1+"-"+ans2;
        }
        else
            return null;
    }
    private String IsNumber(int index){
        String term = getFromText(index) ;
        StringBuilder number = new StringBuilder();
        int i = 0;
        int counter = 0 ;
        for (char c:
                term.toCharArray()) {
            if((((int)c) >= 48 && ((int)c)<=57) || c==',' || c=='.' || c=='/'){
                if(c != ',') {
                    number.append(c);
                }
                if(c == '.') {
                    counter++;
                }
                if(c  == ',' && counter>0){
                    return null;
                }
            }else{
                return null ;
            }
            i++;
        }

        return editNumberKMB(index, number.toString());
    }

    private String checkIfTermHasConnectionToNumber(int index ){
        /* number ; "," ; . ; % ; $ ; m,bn......*/
        boolean dollars = false;
        String term = getFromText(index) ;
        if(term.startsWith("$")){
            dollars = true ;
            term = term.substring(1) ;
        }
        int i = 0 ;
        StringBuilder number = new StringBuilder();
        for (char c:
                term.toCharArray()) {
            if((((int)c) >= 48 && ((int)c)<=57) || c==',' || c=='.' || c=='/'){
                //    System.out.println(c);
                if(c != ',') {
                    number.append(c);
                }
            }else{
                //    System.out.println("foult :" + c);
                break;
            }
            i++;
        }
        boolean endsWithBollean = false;
        if(i!=term.length()) {

            String endTerm = term.substring(i);

            String[] endsWith = {"$","%", "m", "bn"};
            for (int j = 0; j < endsWith.length; j++) {
                if (endTerm.equals(endsWith[j])) {
                    if(i+endsWith[j].length()==term.length() && endsWith[j].length()!=term.length()){
                        return number.toString() ;
                    }
                }
            }
        }else return number.toString() ;
        return null;
    }
    private String IsPercent(int index){
        String word=getFromText(index);
        if(word.endsWith("%") || getFromText(index+1).equals("percent") || getFromText(index+1).equals("percentage")){
            if( word.endsWith("%")){
                return word;
            }else {
                indexDoc++;
                return word + "%";
            }
        }
        return null;
    }


    private String IsPrice(int index){
        String word =getFromText(index);
        String newTerm=checkIfTermHasConnectionToNumber(index);
        boolean isPrice = false;
        if(word.startsWith("$")){
            isPrice = true;
        }else if(word.endsWith("$")){
            isPrice = true ;
        }else if(checkIfTermHasConnectionToNumber(index+1)!=null  &&
                getFromText(index+1).contains("/")&&
                getFromText(index+2).equals("Dollars")) {
            isPrice = true;
        }else{
            String[] ls = {"Dollars", "m Dollars","bn Dollars","billion U.S. dollars","billion",
                    "million U.S. dollars","million","trillion U.S. dollars"};
            String str = getFromText(index+1)+" "+getFromText(index+2)+" "+getFromText(index+3);
            for (int i=0 ; i<ls.length ; i++){
                if(str.startsWith(ls[i])){
                    System.out.println(ls[i]);
                    System.out.println(str);
                    indexDoc=indexDoc+ls[i].split(" ").length ;
                    System.out.println(indexDoc+"check");
                    isPrice=true;
                    break;
                }
            }
        }

        if(isPrice==false){
            return null;
        }

        if(! newTerm.contains("/")) {
            System.out.println(newTerm);
            if(newTerm.equals("")){
                System.out.println("empty term why????");
                return null;
            }
            Double newNumber = Double.parseDouble(newTerm);
// חסר מקרים רבים מיוחדים עם סיומות
            if (getFromText(index + 1).equals("bn")||getFromText(index + 1).equals("billion")) {
                newNumber = newNumber * 1000000000;
            }
            if (getFromText(index + 1).equals("m") ||getFromText(index + 1).equals("million") ) {
                newNumber = newNumber * 1000000;
            } else if (getFromText(index + 1).equals("trillion")) {
                newNumber = newNumber * 1000000000000.0;
            }


            if (newNumber >= 1000000) {
                newNumber = newNumber / 1000000;
                DecimalFormat format = new DecimalFormat("0.###");
                format.setRoundingMode(RoundingMode.DOWN);
                newTerm = format.format(newNumber) + " M";
            }
        }
        if(checkIfTermHasConnectionToNumber(index+1)!=null && getFromText(index+1).contains("/")){
            index++;

            newTerm = newTerm +" "+ getFromText(index) ;

        }
//        if(getFromText(index+1).equals("Dollars")){
//            isPrice = true;
//        }
        if(isPrice){
            newTerm = newTerm + " Dollars";
            indexDoc++;
            return newTerm;
        }


        return null;
    }
    public String IsDate(int index){
        Map<String, String> months = new HashMap<String, String>()
        {{
            put("JANUARY","01");put("FEBRUARY","02");put("MARCH","03");put("APRIL","04");put("MAY","05");put("JUNE","06");put("JULY","07");put("AUGUST","08");put("SEPTEMBER","09");
            put("OCTOBER","10");put("NOVEMBER","11");put("DECEMBER","12");put("January","01");put("February","02");put("March","03");put("April","04");put("May","05");
            put("June","06");put("July","07");put("August","08");put("September","09");put("October","10");put("November","11");put("December","12");put("Jan","01");
            put("Feb","02");put("Mar","03");put("Apr","04");put("Jun","06");put("Jul","07");put("Aug","08");put("Sep","09");put("Oct","10");put("Nov","11");put("Dec","12");put("JAN","01");put("FEB","02");put("MAR","03");put("APR","04");put("JUN","06");
            put("JUL","07");put("AUG","08");put("SEP","09");put("OCT","10");put("NOV","11");put("DEC","12");
        }};
        String check=text.get(index);
        String next=text.get(index+1);
        if(months.get(check)==null&&months.get(next)==null)
            return null;
        if(checkOnlyNumbers(check)==false&&checkOnlyNumbers(next)==false)
            return null;
        if(months.get(check)!=null){
            int size=next.length();
            if(size>2)
                return next+"-"+months.get(check);
            return months.get(check)+"-"+next;
        }
        return months.get(next)+"-"+check;
    }


    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    public boolean checkOnlyNumbers(String word){
        if (word == null) {
            return false;
        }
        int length = word.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (word.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = word.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }


    public String isBetween(int index){
        String check=getFromText(index);
        if(check!="between" && check!="Between")
            return null;
        String num1=IsNumber(index+1);
        String num2=IsNumber(index+3);
        if( num1==null||num2==null ||text.get(index+2)!="and")
            return null;
        return "between "+num1+" and "+num2;
    }
    private String editNumberKMB(int index , String Number ){// number && corrent index
        if(Number.contains("/")){
            return Number;
        }
        String str = checkIfTermHasConnectionToNumber(index+1);
        String add_finish = "";
        if(str!=null){
            index++ ;
        }
        Double newNumber = Double.parseDouble(Number) ;

        if(getFromText(index+1).equals("Thousand") ){
            newNumber=newNumber*1000;
            indexDoc++;
        }else if(getFromText(index+1).equals("Million") || getFromText(index+1).equals("m")){
            newNumber=newNumber*1000000;
            indexDoc++;
        }else if(getFromText(index+1).equals("Billion") || getFromText(index+1).equals("bn")) {
            newNumber = newNumber * 1000000000;
            indexDoc++;
        }

        if(newNumber > 1000000000){
            add_finish="B";
            newNumber = newNumber/1000000000 ;
        }else if(newNumber > 1000000){
            add_finish="M";
            newNumber = newNumber/1000000 ;
        }else if(newNumber > 1000){
            add_finish="K";
            newNumber = newNumber/1000 ;
        }
        DecimalFormat format = new DecimalFormat("0.###");
        format.setRoundingMode(RoundingMode.DOWN);
        String st = format.format(newNumber);
        if(str!=null && getFromText(index).contains("/")){
            indexDoc++;
            str = st +" "+ getFromText(index);

        }else{
            str = st ;
        }

        str = str+add_finish;

        return str;
    }

    private String getFromText(int i){
        if(i>=text.size()){
            return " ";
        }
        return text.get(i);
    }
}
