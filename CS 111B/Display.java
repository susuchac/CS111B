// Programmer : Susie Chac
// Homework: #1
// Course: CS111B
// Date: 06/19/16
// Objective: To display any phrase a user inputs into the command line
// under the four following options:
//     -l: displays the phrase in all lowercase letters, horizontally
//       i.e. input:  java Display -h Hello Abbas
//            output: hello abbas
//     -u: displays the phrase in all uppercase letters, horizontally
//       i.e. input:  java Display -u Hello Abbas
//            output: HELLO ABBAS
//     -v: displays the phrase vertically, by words
//       i.e. input:  java Display -v Hello Abbas
//            output: Hello
//                    Abbas
//     -h: displays the phrase horizontally
//       i.e. input:  java Display -h Hello Abbas
//            output: Hello Abbas
// To compile this program: java Display.java
// To run this program: java Display option(-l,-u,-v,-h) anySentence

import java.lang.String;

public class Display
{
//****************************print()**************************************
    public static void print(String str)
    {
        System.out.print(str);
    }
//****************************println()************************************ 
    public static void println(String ... str)
    {
        // prints empty string if no args, prints input string otherwise
        if(str.length==0)
            System.out.println();
        else
            System.out.println(str[0]);
    }
//****************************die()****************************************
    public static void die(String ... errmsg)
    {
        if(errmsg.length==0)
            System.exit(1);
        println(errmsg[0]);
        System.exit(1);
    }
//****************************printUpperCase()*****************************
    public static void printUpperCase(String str[])
    {
        // prints out string horizontally and in all uppercase letters
        for(String w:str)
            print(w.toUpperCase()+" ");
        println();
    }
//****************************printLowerCase()*****************************
    public static void printLowerCase(String str[])
    {
        // prints out string horizontally and in all lowercase letters
        for(String w:str)
            print(w.toLowerCase()+" ");
        println();
    }
//****************************printHorizontal()****************************
    public static void printHorizontal(String str[])
    {
        // prints out string horizontally
        for(String w:str)
            print(w+" ");
        println();
    }
//****************************printVertical()******************************
    public static void printVertical(String str[])
    {
        // prints out string vertically, by words
        for(String w:str)
            println(w+" ");
    }
//****************************main()***************************************
    public static void main(String args[])
    {
        if((args.length>=0 && args.length<=1) || args.length < 0)
        {
            // error if no input in command line
            // or if option entered without sentence following it
            die("usage: java Display option(-u,-l,-v,-h) anySentence");     
        }
        // sets option equal to first string in args
        String option = args[0];
        // new array to hold sentence of length args-1, excluding option
        String sentence[] = new String[args.length-1];
        for(int i=1; i<args.length; ++i)
        {
            sentence[i-1] = args[i];
        }
        switch(option)
        {
            // print according to 4 options, error results otherwise
            case "-l": printLowerCase(sentence); break;
            case "-u": printUpperCase(sentence); break;
            case "-v": printVertical(sentence); break;
            case "-h": printHorizontal(sentence); break;
            default: die("invalid option. valid options are -u, -l, -v, -h");
        }
    }        
}
