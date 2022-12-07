
class StockBuySell{

	static void stockBuySell(int[] arr){
		int iter = 0, buy = 0, sell = 0, profit = 0;
		boolean profitPossible = true;
		while( iter < arr.length-1){

			while(iter < arr.length-1 && arr[iter] > arr[iter+1])
				iter++;

			if(iter == arr.length){
				profitPossible = false;
				break;
			}
			buy = iter;
			iter++;
			while(iter < arr.length-1 && arr[iter] < arr[iter+1])
				iter++;
			if(iter == arr.length)
				sell = iter-1;
			else 
				sell = iter;

			profit += (arr[sell]-arr[buy]);
			System.out.println("Buy at: " + buy + "     " + "Sell at: " + sell);
		}

		if(!profitPossible)
			System.out.println("There is not possible way of getting profit");
		else 
			System.out.println("Total Profit: " + profit);
	}

	static void stockBuySell1(int[] arr){
		int iter = 0, diff = 0, profit = 0;

		while( iter < arr.length-1){

			diff = arr[iter+1] - arr[iter];
			if(diff > 0) 
				profit += diff;

			iter++;
		}
		System.out.println(profit);
	}


	public static void main(String[] args){
		int[] arr = {100, 180, 260, 310, 40, 535, 695};
		stockBuySell1(arr);
	}
}