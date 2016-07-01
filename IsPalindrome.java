// Programmer: Susie Chac
// Homework: #2
// Course: CS111B
// Date: 06/26/2016
// Objective: The objective of this program is to check whether
//            or not a phrase inputted into the command line
//            is a palindrome or not.
// To compile: javac IsPalindrome.java
// To run:     java IsPalindrome phrase
// Note: Surround each phrase with apostrophes(') or quotation
//        marks(") to help special characters to safely enter the
//        program, because they can cause unexpected effects due 
//        to their functions in LINUX/UNIX.
//
//        If the phrase contains an apostrophe('), surround the
//        whole phrase in quotation marks(").
//
//        If the phrase contains quotation marks("), surround the
//        whole phrase in apostrophes(').
//
//        We need to do this  because Java's command line requires
//        quote marks to be closed, and it cannot handle only one
//        of those characters.

import java.lang.String;

public class IsPalindrome
{
//*********************println()**************************************
    public static void println(String ... str)
    {
        if(str.length==0)
            System.out.println();
        else
            System.out.println(str[0]);
    }
//*********************die()******************************************
    public static void die(String ... errmsg)
    {
        if(errmsg.length==0)
            System.exit(1);
        println(errmsg[0]);
        System.exit(1);
    }
//*********************reverse()**************************************
    public static String reverse(String str)
    {
        // reverses a String
        StringBuilder sb = new StringBuilder(str);
        return(sb.reverse().toString());
    }
//*********************isAlpha()**************************************
    public static boolean isAlpha(char c)
    {
        // checks if char is an alphabet letter
        return((c>='A'&&c<='Z') || (c>='a'&&c<='z'));
    }
//*********************isDigit()**************************************
    public static boolean isDigit(char c)
    {
        // checks if char is a number
        return(c>='0'&&c<='9');
    }
//*********************isAlNum()**************************************
    public static boolean isAlNum(char c)
    {
        // checks if char is an alphanumeric character
        return(isAlpha(c) || isDigit(c));
    }
//*********************join()*****************************************
    public static String join(String delim, String str[])
    {
        // joins an array of Strings with a space as a delimiter
        StringBuilder sb = new StringBuilder();
        for(String t:str)
        {
            sb.append(t).append(delim);
        }
        String s = sb.toString();
        return(s.substring(0,s.length()-delim.length()));
    }
//*********************filter()***************************************
    public static String filter(String phrase)
    {
        // filters out all non-alphanumeric characters in phrase
        String filtered = "";
        for(int i=0; i<phrase.length(); ++i)
        {
            if(isAlNum(phrase.charAt(i)))
                filtered += phrase.charAt(i);
        }
        return filtered;
    }
//**********************main()****************************************
    public static void main(String args[])
    {
        if(args.length==0) die("Usage: java IsPalindrome phrase");
        String unfiltered = join(" ", args);
        String alNumPhrase = filter(unfiltered);
        if(alNumPhrase.equalsIgnoreCase(reverse(alNumPhrase)))
            println(unfiltered + " is a palindrome");
        else
            println(unfiltered + " is not a palindrome");
    }
}
