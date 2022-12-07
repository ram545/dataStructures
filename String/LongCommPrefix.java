


class LongCommPrefix{


	static String longCommPrefix(String s1, String s2){
		int iter = 0, len;
		len = (s1.length() > s2.length()) ? s2.length() : s1.length();
		if(len == 0)
			return "";

		while(iter < len){
			if(s1.charAt(iter) != s2.charAt(iter))
				break;
			iter++;
		}
		if(iter == 0)
			return "";
		else
			return s1.substring(0,iter);
	}

	public static void main(String[] args){
		String[] s = {"aprple", "apre",
            "april", "apreil"};
		String start = s[0];
		int iter = 1, len = s.length;
		while( iter < len){
			start = longCommPrefix(start, s[iter]);
			iter++;
		}
		System.out.println(start);
	}
}