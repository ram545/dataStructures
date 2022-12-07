

class ValidateIP{

	public static void main(String[] args){
		String ip = "256.0.0.1";
		String[] input = ip.split("\\.");
		boolean check = true;
		int number = 0, iter = 0;
		char c;
		for(String s : input){
			iter = 0;
			while(iter < s.length()){
				c = s.charAt(iter);
				if(c < '0' || c > '9'){
					check = false;
					break;
				}
				number = number*10 + (c-'0');
				iter++;
			}
			if(!check)
				break;
			
			if(number < 0  || number > 255){
				check = false;
				break;
			}
			number = 0;
		}

		if(check)
			System.out.println("Valid");
		else 
			System.out.println("Not Valid");

	}
}