
public class ImplementAtoi {

	static int aToI(String s){
		int iter = 0, number = 0, sign = 1;
		while(iter < s.length()){
			if(s.charAt(iter) == '-' && sign != -1)
				sign = -1;
			else if(s.charAt(iter) == ' '){
				if(number != 0)
					return 0;
			}
			else if(s.charAt(iter) >= '0' || s.charAt(iter) <= '9'){
				if(number > Integer.MAX_VALUE/10)
					return (sign == -1)? Integer.MIN_VALUE: Integer.MAX_VALUE;
				number = number*10 + (s.charAt(iter)-'0');
			}
			else
				return 0;
			iter++;
		}
		return sign*number;
	}

    public static void main(String... args){
		String str = "   86475 464589";
		int val = aToI(str);
		System.out.println(val);
    }
}
