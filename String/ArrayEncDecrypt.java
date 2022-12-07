import java.io.*;
import java.util.*;

class Solution {

  static String decrypt(String word) {
    // your code goes here
    int[] input = new int[word.length()];
    int iter = 1, diff;
    char temp, prev;
    String result = "";
    prev = word.charAt(0);
    while(iter < word.length()){
        temp = word.charAt(iter);
        diff = temp-prev;

        while(diff < 97)
            diff += 26;
          
        result += (char)diff;
        prev = temp;
        iter++;
    }
    temp = (char)(word.charAt(0)-'a' + 96);
    result = temp + result;
    return result;
  }

  public static void main(String[] args) {
      String s = "flgxswdliefy";
      System.out.println(decrypt(s));
  }

}