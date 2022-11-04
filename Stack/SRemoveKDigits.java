class MyStack{
	int capacity;
	double loadFactor;
	char[] arr;
	int top;
	
	MyStack(){
		arr = new char[4];
		this.capacity = 4;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity){
		arr = new char[capacity];
		this.capacity = capacity;
		this.loadFactor = 0.75;
		this.top = -1;
	}

	MyStack(int capacity, int loadFactor){
		arr = new char[capacity];
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
		char[] newArr = new char[newCap];
		for( iter = 0; iter <= (capacity*loadFactor); iter++){
			newArr[iter] = arr[iter];
		}
		arr = newArr;
		capacity = newCap;
	}	

	public void push(char val){
		if(top < (loadFactor*capacity))
			arr[++top] = val;
		else{
			enlargeStack();
			arr[++top] = val;
		}
	}

	public char peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Character.MIN_VALUE;
		}
		else 
			return arr[top];
	}

	public char pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Character.MIN_VALUE;
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


class SRemoveKDigits{
	static MyStack ms;

	SRemoveKDigits(){
		ms = new MyStack();
	}

	static String calcMinNumber(String s,int K){
		int iter = 0, length = s.length();
		String result = "";
		while(iter < length && K > 0){
			if(ms.isEmpty())
				ms.push(s.charAt(iter));
			else{
				while(!ms.isEmpty() && ms.peek() > s.charAt(iter)){
					if(K > 0){
						K--;
						ms.pop();
					}
					else 
						break;
				}
				ms.push(s.charAt(iter));
			}
			iter++;
		}
		while(!ms.isEmpty()){
			result = ms.peek() + result;
			ms.pop();
		}
		while(iter < length){
			result += s.charAt(iter);
			iter++;
		}
		return result;
	}

	public static void main(String args[]){
		SRemoveKDigits span = new SRemoveKDigits();
		String s = "121198";
		int K = 2;
		String result = calcMinNumber(s,K);
		System.out.println(result);
	}
}