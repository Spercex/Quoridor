/**
 * this class effect operation on files
 */

package view;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class RWFile {

/**
 * Make an ArrayList of String from a file
 * @param  fileName the file name containing strings
 * @return the new ArrayList of strings
 */
  public static ArrayList<String> readFile (String fileName) {
    ArrayList<String> file = new ArrayList<String> ();
    try {
      Scanner in = new Scanner (new FileReader (fileName));
      while (in.hasNextLine()) {
        file.add(in.nextLine());
      }
      in.close();
    }
    catch (Exception e) {
      System.out.println("file not found : '"+fileName+"'");
      e.printStackTrace();
    }
    return file;
  }




/**
 * write string from ArrayList nto a file
 * @param liste    the ArrayList of string
 * @param fileName the path of the destination file name
 */
  public static void writeFile(ArrayList<String> liste, String fileName) {
    try {
      PrintWriter out = new PrintWriter (fileName);
      for(String line: liste) {
        out.println (line);
      }
      out.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found : '"+fileName+"'");
      e.printStackTrace();
    }
  }

  /**
   * write string from Hashmap into a file
   * @param map    the HashMap of data
   * @param fileName the path of the destination file name
   */
  public static void writeMap (HashMap<String, Double> map, String fileName) {
    try {
      PrintWriter out = new PrintWriter (fileName);
			for (String key: map.keySet()){
			    out.println(key + "     " + map.get(key).toString());
      }
      out.close();
    }
    catch (Exception e) {
      System.out.println("file not found : '"+fileName+"'");
      e.printStackTrace();
    }
  }
}
