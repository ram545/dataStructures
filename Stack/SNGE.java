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


class SNGE{
	static MyStack ms;

	SNGE(){
		ms = new MyStack();
	}

	static int[] calcNGE(int[] arr){
		int iter = 0, length = arr.length;
		int[] result = new int[length];
		iter = length;
		while(iter-- > 0){
			if(ms.isEmpty()){
				result[iter] = -1;
				ms.push(arr[iter]);
			}
			else{
				while(!ms.isEmpty() && arr[iter] > ms.peek())
					ms.pop();
				if(ms.isEmpty())
					result[iter] = -1;
				else
					result[iter] = ms.peek();
				ms.push(arr[iter]);
			}
		}
		return result;
	}

	public static void printNGE(int[] arr){
		int iter = 0, length = arr.length;
		while(iter < length)
			System.out.print(arr[iter++] + " ");
		System.out.println("");
	}	

	public static void main(String args[]){
		SNGE span = new SNGE();
		int[] arr = new int[]{11,13,21,3};
		printNGE(arr);
		int[] result = calcNGE(arr);
		printNGE(result);
		//printSpan(result);
	}
}