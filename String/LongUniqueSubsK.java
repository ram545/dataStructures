import java.util.Arrays;
import java.lang.Math;

public class LongUniqueSubsK {


	static int kUniqueSubString(String input, int distinct){
		int[] hash = new int[26];
		int start = 0, iter = 0, currDistinct = 0, maxLen = Integer.MIN_VALUE, a = 0, b = 0;
		Arrays.fill(hash, -1);
		while(iter < input.length()){
			if(currDistinct <= distinct){
				if(hash[input.charAt(iter)-'a'] == -1){
					currDistinct++;
				}
				hash[input.charAt(iter)-'a']++;
			}

			while(currDistinct > distinct){
				maxLen = Math.max(maxLen, (iter-start));
				if(maxLen == iter-start){
					a = start;
					b = iter;
				}
				hash[input.charAt(start)-'a']--;
				if(hash[input.charAt(start)-'a'] == -1){
					currDistinct--;
					start++;
					break;
				}
				start++;
			}
			iter++;
		}
		System.out.println(input.substring(a,b));
		return maxLen;
	}

    public static void main(String... args){
       String s = "aabbcdcefggksdbglagjlgslkjsgljslgdj";
       int K = 5;
       System.out.println(kUniqueSubString(s, K));
    }
}
