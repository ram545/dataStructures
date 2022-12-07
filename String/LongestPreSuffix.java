class LongestPreSuffix{



	static String findLongestPrefixSuffix(String s){
		int iter = 0, start = (s.length()/2)+1, end = s.length();
		while( start < s.length()){
			if(s.charAt(iter) != s.charAt(start))
				iter = 0;
			else 
				iter++;
			start++;
		}

		if(iter == 0)
			return "";
		else
			return s.substring(0,iter);

	}

	public static void main(String[] args){
		String s = "abbcdaabc";
		String output = findLongestPrefixSuffix(s);
		System.out.println(output);
	}
}