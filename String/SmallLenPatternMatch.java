import java.util.HashMap;

public class SmallLenPatternMatch {

	public static String smallestLengthMatch(String input, String pattern){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int iter = 0, start = 0, minLen = Integer.MAX_VALUE, count = 0, startIndex = 0, endIndex = 0;
		char val;
		while(iter < pattern.length()){
			val = pattern.charAt(iter);
			if(map.containsKey(val))
				map.put(val, map.get(val)+1);
			else{
				count++;
				map.put(val, 1);
			}
			iter++;
		}
		iter = 0;
		while(iter < input.length()){
			val = input.charAt(iter);

			if(map.containsKey(val)){
				map.put(val, map.get(val)-1);
				if(map.get(val) == 0)
					count--;
			}

			while(count <= 0){
				if(minLen > (iter-start)){
					minLen = iter-start;
					startIndex = start;
					endIndex = iter;
				}
				val = input.charAt(start);
				if(map.containsKey(val)){
					map.put(val, map.get(val)+1);
					if(map.get(val) > 0)
						count++;
				}
				start++;
			}
			iter++;
		}
		return input.substring(startIndex, endIndex+1);
	}


    public static void main(String... args){
        String s = "geeksforgeekstri";
        String pattern = "tris";
        String len = smallestLengthMatch(s,pattern);

        if(len == "")
        	System.out.println("Not Found");
        else 
        	System.out.println(len);
    }
}
