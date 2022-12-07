import java.util.HashSet;

public class UnionIntersection {


	static void getUnion(int[] a, int[] b){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : a)
			set.add(i);
		for(int i: b)
			set.add(i);

		set.forEach( val -> { System.out.print(val + " ");});
		System.out.println("");
	}

	static void getIntersection(int[] a , int[] b){
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> output = new HashSet<Integer>();
		for(int i : a)
			set.add(i);
		for(int i : b){
			if(set.contains(i))
				output.add(i);
		}
		output.forEach( val -> { System.out.print(val + " ");});
		System.out.println("");
	}

    public static void main(String... args){
        int a[] = { 1, 2, 5, 6, 2, 3, 5, 7, 3 };
        int b[] = { 2, 4, 5, 6, 8, 9, 4, 6, 5, 4 };
 
        getUnion(a, b);
        getIntersection(a, b);
    }
}
