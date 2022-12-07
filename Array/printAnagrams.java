import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class printAnagrams {

	static void printAnagrams(String[] wordArray){
		String sorted = "";
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String word : wordArray){
			char[] temp = word.toCharArray();
			Arrays.sort(temp);
			sorted = String.valueOf(temp);
			if(map.containsKey(sorted)){
				ArrayList<String> al = map.get(sorted);
				al.add(word);
				map.put(sorted, al);
			}
			else{
				ArrayList<String> ls = new ArrayList<String>();
				ls.add(word);
				map.put(sorted, ls);
			}
		}

		map.forEach( (key, value) -> {
			Iterator<String> iter = value.iterator();
			while(iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println("");
		});
	}


    public static void main(String... args){
        String[] input =  { "cat", "dog", "tac", "edoc", "god", "tacact", "act", "code", "deno", "node", "ocde", "done", "catcat" };
        printAnagrams(input);
    }
}
