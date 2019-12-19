import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class Parse implements ParseInterface{
    private Map<String,Integer> DATA ;
    private ArrayList<String> text; //List of document words without stop words or blank spaces.
    private HashSet<String> stopWords;
    private int indexDoc ;
    private static volatile boolean stem;
    private HashSet<String> endsOrStarts;
//    public static volatile AtomicInteger atomicInteger = new AtomicInteger();
//    public static volatile HashSet<String> hsNumber = new HashSet();
//    public static volatile Object look = new Object();

    public Parse(String corpus){
        add_stopWords(corpus);
        endsOrStarts = new HashSet<String>(Arrays.asList("(", ")", ".","*","!","?",".",",",":",";","-","]","[",",","\"","'","[","]","{","}","@","#","^","&","_"));
    }

    /**
     * @param text A string that has the document contents
     * @return returns a list of terms after processing and activation of rules
     */
    public Map<String,Integer> parseIt(String text){

        /*run on each file text - remove stop words ,parse it(and increases number of appearances), stems it , data analysis(the term with the most appearances,number of all terms,*/
        String[] str2 = text.split("[:\\s\\r?\\n]+");
        DATA = new HashMap<>();
        this.text = new ArrayList<>();
        for(int i=0 ; i<str2.length ;i++) {
            if(str2[i].equals("U.S.")) {  //checks a single case of word that falls after cleaning
                this.text.add(str2[i]);
                continue;
            }
            if(!Separate(str2[i])&&str2[i].length()>0) //checks if the word is not ""
                this.text.add(str2[i]);
        }

        for(indexDoc=0 ; indexDoc< this.text.size() ;indexDoc++){
            String str;


            str=IsRange(indexDoc);
            if(str!=null){  //checks if the word is under the Range rule
                AddToData(str,false);
                continue;
            }

            str=IsEntity(indexDoc);
            if(str!=null){   //checks if the word is an entity
                AddToData(str,false);
                continue;
            }
            this.text.set(indexDoc,CleanWord(getFromText(indexDoc)));  //cleans the word from start and end
            if(this.text.get(indexDoc).length()==0)
                continue;
            str=isBetween(indexDoc);
            if(str!=null){
                AddToData(str,false);
                continue;
            }
            str=IsDate(indexDoc);
            if(str!=null){  //checks if the word is a date
                AddToData(str,true);
                continue;
            }
            if(checkIfTermHasConnectionToNumber(indexDoc)!=null){
                str=getNumber(indexDoc);
                if(str == null)  //checks if the word is a number
                    continue;
                AddToData(str,true);
                continue;
            }
            if(stopWords.contains(getFromText(indexDoc))||stopWords.contains(getFromText(indexDoc).toLowerCase())||stopWords.contains(getFromText(indexDoc).substring(0,1).toUpperCase()+getFromText(indexDoc).toLowerCase().substring(1))) //checks if the word is a Stop Word
                continue;
                AddToData(getFromText(indexDoc),false);
        }
      //  System.out.println(DATA);
        return DATA;
    }

    /**
     * @param word The word that needs cleaning
     * @return The word after cleaning from start and ending
     */
    private String CleanWord(String word){
        while(word.length()!=0 && endsOrStarts.contains(String.valueOf(word.charAt(word.length()-1))))
            word=word.substring(0,word.length()-1);
        if(!word.contains("(703)")) {  //checks a special case of a phone number
            while ((word.length() != 0 && endsOrStarts.contains(String.valueOf(word.charAt(0)))))
                word = word.substring(1);
            return word;
        }
        else
            AddToData(word,true);
        return "";

    }

    /**
     * @param word The word that needs separating
     * @return The words after separating
     * This function checks if there is -- in the word and if there is,separates to different words
     */
    private boolean Separate(String word){
        if(!word.contains("--"))
            return false;
        int index=0;
        String first="";
        String second="";
        for (int i = 0; i <word.length() ; i++) {
            if (word.charAt(i) == '-' && word.charAt(i + 1) == '-') {
                index = i;
                break;
            }
            first += word.charAt(i);
        }
        for (int i = index+2; i <word.length() ; i++) {
            second+=word.charAt(i);
        }
        if(first.length()>0)
        this.text.add(first);
        if(second.length()>0)
        this.text.add(second);
        return true;
    }


    /**
     * @param corpus The path to the corpus
     * This function adds the stop words to a list for later use
     */
    private void add_stopWords(String corpus){
        stopWords=new HashSet<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(corpus+"/stop_words.txt"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                stopWords.add(line);
            }
            reader.close();
        }
        catch (Exception e)
        {
          //  System.err.format("Exception occurred trying to read '%s'.", "StopWords.txt");
            e.printStackTrace();
        }
    }

    /**
     * @param word The word that needs stemming
     * @return The word after stemming
     */
    private String StemWord(String word){
        Stemmer stemmer=new Stemmer();
        stemmer.add(word.toCharArray(),word.length());
        stemmer.stem();
        return stemmer.toString();
    }

    public static void TurnOnStem(){
        stem=true;
    }

    public static void TurnOffStem(){
        stem=false;
    }

    /**
     * @param word The term that needs to be added
     * @param number Check if the term is a number for a special case of adding
     * This function adds the term after processing to the map that gets sent to the Indexer
     */
    private void AddToData(String word,boolean number){
        if(stem)
            word=StemWord(word);
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


    /**
     * @param index The current index of the separated text
     * @return The number if it is one
     * This function checks through the many rules of numbers and returns the right term if it is a number
     */
    private String getNumber(int index) {
        String str;
        str = this.IsPercent(index);
        if (str != null)
            return str;

        str = this.IsPrice(index);
        if (str != null)
            return str;

        str = this.IsWeight(index);

        if (str != null)
            return str;

        str = this.IsLength(index);
        if (str != null)
            return str;

        str = this.IsNumber(index);
        if (str != null) {
            return str;
        }

        return null;
    }

    /**
     * @param indexDoc The current index of the separated text
     * @return The entity term
     */
    private String IsEntity(int indexDoc){
        String entity="";
        String word=getFromText(indexDoc);
        int size=1;
        if(Character.isUpperCase(word.charAt(0))&&Character.isUpperCase(getFromText(indexDoc+1).charAt(0))) {
            entity += word;
            if(endsOrStarts.contains(String.valueOf(entity.charAt(entity.length()-1))))
                return null;
            else if(!stopWords.contains(word)&&!stopWords.contains(word.toLowerCase())&&!stopWords.contains(word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1))) //checks if the word is a Stop Word
                AddToData(entity,false);
        }
        else
            return null;
        for (int i = indexDoc+1;Character.isUpperCase(getFromText(i).charAt(0)) ; i++) {
            word=getFromText(i);
            if(IsRange(i)!=null)
                return null;
            entity = entity + " " + word;
            size=i-indexDoc+1;
            if(endsOrStarts.contains(String.valueOf(entity.charAt(entity.length()-1)))){
                entity=CleanWord(entity);
                word=CleanWord(word);
                if(!stopWords.contains(word)&&!stopWords.contains(word.toLowerCase())&&!stopWords.contains(word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1))) //checks if the word is a Stop Word
                    AddToData(word,false);
                this.indexDoc+=size-1;
                return entity;
            }
            if(!stopWords.contains(word)&&!stopWords.contains(word.toLowerCase())&&!stopWords.contains(word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1))) //checks if the word is a Stop Word
                AddToData(word,false);
        }
        if(size==1)
            return null;
        this.indexDoc+=size-1;
        return entity;
    }

    /**
     * @param indexDoc The current index of the separated text
     * @return The range term
     */
    private String IsRange(int indexDoc){
        String w=CleanWord(getFromText(indexDoc));
        if(w.length()<1)
            return null;
        String[]words=w.split("-");
        if (words.length==1)
            return null;
        else if(words.length>=3) {
            for (String word:words) {
                word=CleanWord(word);
                if(word.length()<1)
                    continue;
                if(!stopWords.contains(word)&&!stopWords.contains(word.toLowerCase())&&!stopWords.contains(word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1))) //checks if the word is a Stop Word
                AddToData(word,false);
            }
            return CleanWord(getFromText(indexDoc));
        }
        else if(words.length==2){
            String ans1=words[0],ans2=words[1];
            if(checkIfTermHasConnectionToNumber(indexDoc)!=null) {
                ans1 = getNumber(indexDoc);
            }
            if(checkIfTermHasConnectionToNumber(indexDoc+1)!=null)
                ans2=getNumber(indexDoc+1);
            if(!stopWords.contains(words[0])&&!stopWords.contains(words[0].toLowerCase())&&!stopWords.contains(words[0].substring(0,1).toUpperCase()+words[0].toLowerCase().substring(1))) //checks if the word is a Stop Word
            AddToData(words[0],false);
            if(!stopWords.contains(words[1])&&!stopWords.contains(words[1].toLowerCase())&&!stopWords.contains(words[1].substring(0,1).toUpperCase()+words[1].toLowerCase().substring(1))) //checks if the word is a Stop Word
            AddToData(words[1],false);
            return ans1+"-"+ans2;
        }
        else
            return null;
    }

    /**
     * @param index The current index of the separated text
     * @return The number term
     */
    private String IsNumber(int index){
        String term = getFromText(index) ;
        StringBuilder number = new StringBuilder();
        int i = 0;
        int counter = 0 ;
        if(term.equals("."))
            return null;
        for (char c:
                term.toCharArray()) {
            if((((int)c) >= 48 && ((int)c)<=57) || c==',' || c=='.' || c=='/'){
                if(c != ',') {
                    number.append(c);
                }
                if(c == '.') {
                    counter++;
                }
                if(counter>1){ // changed from c  == ',' || counter>0
                    return null;
                }
            }else{
                return null ;
            }
            i++;
        }

        if(number.toString().length() == 0) return null;
        return editNumberKMB(index, number.toString());
    }

    /**
     * @param index The current index of the separated text
     * @return Checks if the word has a connection to number
     */
    private String checkIfTermHasConnectionToNumber(int index ){
        /* number ; "," ; . ; % ; $ ; m,bn......*/
        boolean dollars = false;
        String term = getFromText(index) ;
        if(term.startsWith("$")){
            dollars = true ;
            term = term.substring(1) ;
        }
        int i = 0 ;
        int y = 0 ;
        StringBuilder number = new StringBuilder();
        for (char c:
                term.toCharArray()) {
            if((((int)c) >= 48 && ((int)c)<=57) || c==',' || c=='.' || c=='/'){
                //    System.out.println(c);
                if(c != ',') {
                    number.append(c);
                }
                if(c == '.') {
                    y++;
                    if(y>1){
                        return null;
                    }
                }
            }else{
                //    System.out.println("foult :" + c);
                break;
            }
            i++;
        }
        if(i==0) return null;
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

    /**
     * @param index The current index of the separated text
     * @return The percent term
     */
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


    /**
     * @param index The current index of the separated text
     * @return The price term
     */
    private String IsPrice(int index){
        if(getFromText(index+2).equals("pounds"))
            return null;
        String word =getFromText(index);
        String newTerm=checkIfTermHasConnectionToNumber(index);
        if(newTerm == null) return null;
        boolean isPrice = false;
        if(word.startsWith("$")){
            isPrice = true;
            if(IsUnderMillion(word.substring(1),index))
                return word.substring(1)+" Dollars";
        }
        else if(checkIfTermHasConnectionToNumber(index+1)!=null  &&
                getFromText(index+1).contains("/")&&
                getFromText(index+2).equals("Dollars")) {
            isPrice = true;
        }else{
            String[] ls = {"Dollars", "m Dollars","bn Dollars","billion U.S. dollars","billion",
                    "million U.S. dollars","million","trillion U.S. dollars"};
            String str = getFromText(index+1)+" "+getFromText(index+2)+" "+getFromText(index+3);
            for (int i=0 ; i<ls.length ; i++){
                if(str.startsWith(ls[i])){
                 //   System.out.println(ls[i]);
                 //   System.out.println(str);
                    indexDoc=indexDoc+ls[i].split(" ").length ;
                 //   System.out.println(indexDoc+"check");
                    isPrice=true;
                    break;
                }
            }
        }

        if(isPrice==false){
            return null;
        }

        if(! newTerm.contains("/")) {
          //  System.out.println(newTerm);
            if(newTerm.equals("")){
            //    System.out.println("empty term why????");
                return null;
            }
            Double newNumber = Double.parseDouble(newTerm);
// חסר מקרים רבים מיוחדים עם סיומות
            if (getFromText(index ).endsWith("bn")||getFromText(index + 1).equals("bn")||getFromText(index + 1).equals("billion")) {
                newNumber = newNumber * 1000000000;
            }
            if (getFromText(index ).endsWith("m")||getFromText(index + 1).equals("m") ||getFromText(index + 1).equals("million") ) {
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

    /**
     * @param index The current index of the separated text
     * @return The weight term
     */
    private String IsWeight(int index){
        if(!getFromText(index+1).equals("tons")&&!getFromText(index+2).equals("pounds"))
            return null;
        String number=checkIfTermHasConnectionToNumber(index);
        if(number==null)
            return null;
        String amount=getFromText(index+1);
        if(amount.equals("billion")){
            if(number.contains(".")){
                String[] check=number.split("\\.");
                number = number.replace(".", "");
                if(check[1].length()<2)
                    number += "00M pounds";
                else
                    number += "0M pounds";

            }
            else
                number+="000M pounds";
        }
        else if(amount.equals("million"))
            number+="M pounds";
        else{
            if(number.contains(".")){
                String[] check=number.split("\\.");
                number = number.replace(".", "");
                if(check[1].length()<2)
                    number += "00";
                else
                    number += "0";
            }
            else
                number+="000";
            long num=Long.parseLong(number);
            num=num*2;
            number=num+" pounds";
        }
        return number;
    }


    /**
     * @param index The current index of the separated text
     * @return The date term
     */
    public String IsDate(int index){
        Map<String, String> months = new HashMap<String, String>()
        {{
            put("JANUARY","01");put("FEBRUARY","02");put("MARCH","03");put("APRIL","04");put("MAY","05");put("JUNE","06");put("JULY","07");put("AUGUST","08");put("SEPTEMBER","09");
            put("OCTOBER","10");put("NOVEMBER","11");put("DECEMBER","12");put("January","01");put("February","02");put("March","03");put("April","04");put("May","05");
            put("June","06");put("July","07");put("August","08");put("September","09");put("October","10");put("November","11");put("December","12");put("Jan","01");
            put("Feb","02");put("Mar","03");put("Apr","04");put("Jun","06");put("Jul","07");put("Aug","08");put("Sep","09");put("Oct","10");put("Nov","11");put("Dec","12");put("JAN","01");put("FEB","02");put("MAR","03");put("APR","04");put("JUN","06");
            put("JUL","07");put("AUG","08");put("SEP","09");put("OCT","10");put("NOV","11");put("DEC","12");
        }};
        String check=getFromText(index);
        String next=getFromText(index+1);
        if(months.get(check)==null&&months.get(next)==null)
            return null;
        if(!checkOnlyNumbers(check)&&!checkOnlyNumbers(next))
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

    /**
     * @param word The word that needs checking
     * @return boolean that represents if the word contains only number characters
     */
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
            if ((c < '0' || c > '9')&&c!='.') {
                return false;
            }
        }
        return true;
    }

    /**
     * @param index The current index of the separated text
     * @return The between term
     */
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

    /**
     * @param index The current index of the separated text
     * @param Number
     * @return The number after editing
     */
    private String editNumberKMB(int index , String Number ){// number && corrent index
        if(Number.contains("/")){
            return Number;
        }
        String str = checkIfTermHasConnectionToNumber(index+1);
        String add_finish = "";
        if(str!=null){
            index++ ;
        }
     //   System.out.println("n: "+Number);
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

    /**
     * @param i The current index of the separated text
     * @return The current index from the text after checking for size
     */
    private String getFromText(int i){
        if(i >= text.size()){
            return " ";
        }
        if(text.get(i) == null) return " ";
        return text.get(i);
    }

    /**
     * @param number
     * @param index The current index of the separated text
     * @return The boolean that says if the number is under a million
     */
    private boolean IsUnderMillion(String number,int index){
        String next=getFromText(index+1);
        if(next.equals("m")||next.equals("bn")||next.equals("billion")||next.equals("million")||number.contains("m")||number.contains("bn"))
            return false;
        if(number.contains("/"))
            return true;
        number=number.replace(",","");
        if(!checkOnlyNumbers(number))
            return false;
        Double check=Double.parseDouble(number);
        if(check<1000000)
            return true;
        else
            return false;
    }

    /**
     * @param index The current index of the separated text
     * @return The length term
     */
    private String IsLength(int index){
        String next=getFromText(index+1);
        if(!next.equals("feet")&&!next.equals("miles")&&!next.equals("yards"))
            return null;
        Double number;
        boolean IsInt=false;
        if(!getFromText(index).contains("."))
            IsInt=true;

        try{
            number=Double.parseDouble(getFromText(index));
        }
        catch(NumberFormatException nfe){
            return null;
        }
        if(!IsInt) {
            if (next.equals("feet"))
                return number + " " + next;
            else if (next.equals("yards"))
                return number * 3 + " " + "feet";
            else
                return number * 5280 + " " + "feet";
        }
        else{
            if (next.equals("feet"))
                return Math.round(number) + " " + next;
            else if (next.equals("yards"))
                return Math.round(number) * 3 + " " + "feet";
            else
                return Math.round(number) * 5280 + " " + "feet";
        }
    }
}
