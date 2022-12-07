import java.util.HashMap;
import java.lang.Math;

public class LongSubString {

	static int longestDistinctSubstring(String input){
		int start =0, iter = 0, maxLen = Integer.MIN_VALUE;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char temp = ' ';
		while(iter < input.length()){
			temp = input.charAt(iter);
			if(map.getOrDefault(temp, -1) == 1){
				maxLen = Math.max(maxLen, (iter-start));
				while(input.charAt(start) != temp){
					if(map.containsKey(input.charAt(start)))
						map.remove(input.charAt(start));
					start++;
				}
				start++;
			}
			else 
				map.put(temp, 1);
			iter++;
		}
		return maxLen;
	}

    public static void main(String... args){
        String input = "EEKSFORGEEKS";
        System.out.println(longestDistinctSubstring(input));
    }
}
