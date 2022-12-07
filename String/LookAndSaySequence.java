
public class LookAndSaySequence {

	static String generateNth(int N){
		int prev = 1, iter = 0, iter1 =0, rep = 0;
		String inter = "1", temp;
		iter = 1;
		while(iter < N){
			temp = "";
			iter1 = 0;
			rep = 1;
			while(iter1 < inter.length()-1){
				if(inter.charAt(iter1) == inter.charAt(iter1+1))
					rep++;
				else{
					temp += rep;
					temp += inter.charAt(iter1);
					rep = 1;
				}
				iter1++;
			}
			temp += rep;
			temp += inter.charAt(iter1);
			inter = temp;
			iter++;
		}
		return inter;
	}

    public static void main(String... args){
        int N = 8;
        System.out.println(generateNth(N));
    }
}
