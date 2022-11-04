class MyStack{
	int capacity;
	double loadFactor;
	int[] arr;
	int top;
	
	MyStack(){
		arr = new int[4];
		this.capacity = 4;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity){
		arr = new int[capacity];
		this.capacity = capacity;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity, int loadFactor){
		arr = new int[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		this.top = -1;
	}

	public boolean isEmpty(){
		return (top == -1)? true: false;
	}

	public void enlargeStack(){
		int newCap = 0, iter = 0;
		newCap = 2*capacity;
		int[] newArr = new int[newCap];
		for( iter = 0; iter <= (capacity*loadFactor); iter++){
			newArr[iter] = arr[iter];
		}
		arr = newArr;
		capacity = newCap;
	}	

	public void push(int val){
		if(top < (loadFactor*capacity))
			arr[++top] = val;
		else{
			enlargeStack();
			arr[++top] = val;
		}
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}
		else 
			return arr[top];
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}
		else{
			return arr[top--];
		}
	}

	public void printStack(){
		int iter = top;
		while( iter >= 0){
			System.out.print(arr[iter--] + " ");
		}
		System.out.println("");
	}
}

class SMaxRectArea{
	static MyStack ms;

	SMaxRectArea(){
		ms = new MyStack();
	}

	static Integer calcMaxArea(int[] hist){
		int iter = 0, length = hist.length, sum = 0, sumAtHist = 0, top;
		while( iter < length){
			if(ms.isEmpty() || hist[ms.peek()] <= hist[iter])
				ms.push(iter++);
			else{
				while( !ms.isEmpty() && hist[ms.peek()] > hist[iter]){
					top = ms.peek();
					ms.pop();

					sumAtHist = hist[top]*((ms.isEmpty()) ? iter : (iter - ms.peek() - 1));
					if( sum < sumAtHist)
						sum = sumAtHist;
				}
			}
		}

		while( !ms.isEmpty() ){
			top = ms.peek();
			ms.pop();

			sumAtHist = hist[top]*((ms.isEmpty()) ? iter : (iter - ms.peek() - 1));
			if( sum < sumAtHist)
				sum = sumAtHist;
		}

		return sum;
	}	

	public static void main(String args[]){
		SMaxRectArea span = new SMaxRectArea();
		int[] arr = new int[]{3, 5, 1, 7, 5, 9};
		int result = calcMaxArea(arr);
		System.out.println(result);
	}
}