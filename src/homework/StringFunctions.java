package homework;

import java.sql.SQLOutput;

public class StringFunctions {
    public static void main(String[] args) {
        char[] chars = {'P', 'i', 'c', 's', 'A', 'r', 't'};
        String s = new String(chars);
        System.out.println(s);
        //1
        String s1 = "PicsArt";
        System.out.println("String Length " + s1.length());
        char a = s1.charAt(4);//returns the character at the specified location
        System.out.println(a);
        //2
        String s2 = "Create Amazing Photo & Video Edits With Online Design Tools";
        char[] dest = new char[7];
        s2.getChars(7, 14, dest, 0);//extract more than one character at a time
        System.out.println(dest);
        //3
        char[] arr = s1.toCharArray();//returns an Array of chars
        //4
        String s3 = "picsart";
        System.out.println("s1 equals s3: " + s1.equals(s3));
        System.out.println("s1 equals s3: " + s1.equalsIgnoreCase(s3));
        //5
        System.out.println(s1.startsWith("Pics")); //true because string PicsArt starts with Pics
        System.out.println(s1.endsWith("Art"));//true  because string PicsArt ends with Art
        //6
        System.out.println("Index of A in s1:" + s1.indexOf("A"));
        System.out.println("Index of A in s1 after 3th char:" + s1.indexOf("A",3));
        System.out.println("Index of string rt in s1:"+s1.indexOf("rt"));
        //7
        String s4 = "Everything you can imagine is real.";
        System.out.println("Last 'a' in s4:" + s4.lastIndexOf("a"));
        System.out.println("Last 'a' in s41 whose index<=30:"+s4.lastIndexOf('a', 30));
        System.out.println("Last occurrence of 'in' in st4:"+s4.lastIndexOf("in"));
        System.out.println("Last occurrence of 'in' in  st4 before 15:"+s4.lastIndexOf("in", 15));
        //8
        System.out.println(s1.substring(0,4));//returns a new string that is a substring of given string
        //9
        System.out.println(s1.substring(0,4).concat(s1.substring(4)));//concat() appends the specified string at the end of the given string and returns the combined string.
        //10
        System.out.println(s4.replace('i','*'));//replaces all the occurrences of a oldChar character with newChar character
        //11
        System.out.println("             Everything you can imagine is real.             ".trim());// returns a String after removing leading and trailing white spaces
        //12
        int x = 10;
        System.out.println(String.valueOf(x) + 10);//(example)returns the String representation of int
        //13
        System.out.println(s1.toUpperCase());
        System.out.println(s4.toLowerCase());
        //14
        String result = String.join("-","Everything","you","can","imagine","is","real");
        System.out.println(result);
        //15
        System.out.println(s1.isEmpty());

    }
}
