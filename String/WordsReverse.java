import java.util.Scanner;
import java.util.*;


class WordsReverse{


	static void wordsReverse(String[] words){
		StringBuilder output = new StringBuilder("");
		int iter = words.length-1;
		while(iter>=0){
			output.append(words[iter--]);
			output.append(" ");
		}
		System.out.println(output);
	}

	static void wordsReverseConstantSpace(String[] words){
		int iter = 0, len = words.length;
		String temp;
		while( iter < len/2){
			temp = words[len-iter-1];
			words[len-iter-1] = words[iter];
			words[iter] = temp;
			iter++;
		}

		String output = String.join(" ",words);
		System.out.println(output);	
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String[] words = sentence.split(" ");
		wordsReverse(words);
		wordsReverseConstantSpace(words);

	}

}