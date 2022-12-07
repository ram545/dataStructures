
public class ImplementAtof {

	static double aToF(String s){
		int iter = 0;
		double number = 0.0, sign = 1.0, div = 1.0;
		boolean decimalEnc = false;
		while(iter < s.length()){	
			if(s.charAt(iter) == '-'){
				if(sign == 1.0)
					sign = -1.0;
				else
					return 0;
			}
			else if(s.charAt(iter) == ' '){
				if(number != 0)
					return 0;
			}
			else if(s.charAt(iter) == '.'){
				if(decimalEnc)
					return 0;
				decimalEnc = true;
			}
			else if(s.charAt(iter) >= '0' && s.charAt(iter) <= '9'){
				if(number > Double.MAX_VALUE/10){
					return (sign == 1.0) ? Double.MAX_VALUE : Double.MIN_VALUE;
				}
				number = number*10 + s.charAt(iter)-'0';
				if(decimalEnc)
					div *= 10.0;
			}	
			else
				return 0;
			iter++;
		}
		return ((double)number/div)*sign;
	}

    public static void main(String... args){
		String str = "   -86554.565";
		double val = aToF(str);
		System.out.println(val);
    }
}
