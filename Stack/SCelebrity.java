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


class SCelebrity{
	static MyStack ms;
	static int arr[][];

	SCelebrity(){
		ms = new MyStack();
	}

	static boolean hasAcquiantance(int a,int b){
		return (arr[a][b]==1) ? true : false;
	}

	static int getCelebrity(int n){
		int iter = 0, a = 0, b = 0;
		while(iter < n)
			ms.push(iter++);
		while(! ms.isEmpty()){
			a = ms.peek();
			ms.pop();
			if(ms.isEmpty()){
				ms.push(a);
				break;
			}
			b = ms.peek();
			ms.pop();

			if( hasAcquiantance(a,b) && !hasAcquiantance(b,a))
				ms.push(b);

			if( hasAcquiantance(b,a) && !hasAcquiantance(a,b))
				ms.push(a);
		}

		if(ms.isEmpty())
			return -1;

		return validateCelebrity(ms.peek(),n) ? ms.peek() : -1;
	}

	static boolean validateCelebrity(int key, int n){
		int iter = 0;
		while(iter < n){
			if( iter != key && hasAcquiantance(key,iter))
				return false;
			iter++;
		}
		return true;
	}


	static int recGetCeleb(int n){
		if( n == -1)
			return 0;

		int id = recGetCeleb(n-1);

		if( id == -1)
			return n;

		if( hasAcquiantance(id,n) && !hasAcquiantance(n,id))
			return n;

		if( hasAcquiantance(n,id) && !hasAcquiantance(id,n))
			return id;

		return -1;
	}

	public static void main(String args[]){
		SCelebrity span = new SCelebrity();
		arr = new int[][]{ {0, 0, 1, 0},
           {0, 0, 1, 0},
           {1, 0, 1, 0},
           {0, 0, 1, 0} };
        int id = recGetCeleb(3);
        if( id == -1)
        	System.out.println("Not a Celebrity");
        else
			System.out.println(validateCelebrity(id,4));
	}
}