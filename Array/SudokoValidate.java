import java.util.Arrays;

public class SudokoValidate {


	static boolean inRange(int[][] board){
		for(int[] arr: board){
			for(int i: arr){
				if( i < 0 || i > 9)
					return false;

			}
		}
		return true;
	}

	static boolean checkBlock(int[][] board, int i, int j){
		int iter = i, iter1 = j;
		boolean[] unique = new boolean[9];
		for(; iter < i+3; iter++){
			Arrays.fill(unique, false);
			for(; iter1 < j+3; iter1++){
				if(unique[board[iter][iter1]-1])
					return false;
				unique[board[iter][iter1]-1] = true;
			}
		}
		return true;
	}

	static boolean isValid(int[][] board){
		boolean[] unique = new boolean[9];

		if(!inRange(board))
			return false;

		for(int[] arr: board){
			Arrays.fill(unique, false);
			for(int i: arr){
				if(unique[i-1])
					return false;
				unique[i-1] = true;
			}
		}

		int i = 0, j = 0;
		while( i < board[0].length){
			Arrays.fill(unique, false);
			while(j < board[0].length){
				if(unique[board[j][i]-1])
					return false;
				unique[board[j][i]-1] = true;
				j++;
			}
			i++;
		}


		while(i < board[0].length){
			while(j < board[0].length){
				if(!checkBlock(board, i, j))
					return false;
				j+=3;
			}
			i+= 3;
		}
		return true;
	}


    public static void main(String... args){
        int board[][] =  {{7, 9, 2, 1, 5, 4, 3, 8, 6}, 
             {6, 4, 3, 8, 2, 7, 1, 5, 9},
             {8, 5, 1, 3, 9, 6, 7, 2, 4},
             {2, 6, 5, 9, 7, 3, 8, 4, 1},
             {4, 8, 9, 5, 6, 1, 2, 7, 3},
             {3, 1, 7, 4, 8, 2, 8, 6, 5},
             {1, 3, 6, 7, 4, 8, 5, 9, 2},
             {9, 7, 4, 2, 1, 5, 6, 3, 8},
             {5, 2, 8, 6, 3, 9, 4, 1, 7}};
        System.out.println(isValid(board));
    }
}
