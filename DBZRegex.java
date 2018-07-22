/**
 * This program serves to read a certain block of text from an input file.
 * This is my practice using regular expressions.
 * Originally, this code was written to simulate what needed to be done to help
 * my friend Marcus with his "Oppenheimer Funds" side project.
 *
 * @Author: Md Rahman
 * @Created: 7/21/18
 */

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBZRegex {

     // name of input file
     private static final String INPUT_FILE = "DBZ.txt";

     public static void main(String[] args) {

        try {

            // access the input file
            FileReader file = new FileReader(INPUT_FILE);
            BufferedReader inputFile = new BufferedReader(file);

            // get the entire input file and store as a single string
            String content = new Scanner(inputFile).useDelimiter("\\Z").next();

            // removes all blank lines and tabs from the string we just made
            String adjusted = content.replaceAll("(?m)^[ \t]*\r?\n", "");

            // method to get the block of text we desire
            getText(adjusted);

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check name of file and/or path.");
        }
    } // end main

    // get the block of text we want
    private static void getText(String adjusted){
        // create the two patterns we are searching for
        Pattern p = Pattern.compile("Let's list off our fighters:");
        Pattern q = Pattern.compile("Freezer");

        // assign a matcher to each pattern
        Matcher m = p.matcher(adjusted);
        Matcher n = q.matcher(adjusted);

        // need indexes of patterns so we can get the block of text in between
        int m_index = 0;
        int n_index = 0;
        if (m.find())
            m_index = m.end(); // ending index of first pattern
        if (n.find())
            n_index = n.start(); // starting index of second pattern

        // create a new string with only the block of text between the two patterns
        String s = adjusted.substring(m_index, n_index);
        System.out.println(s);
    } // end getText
} // end class
