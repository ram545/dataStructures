import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.ListIterator;


public class BFS {

	private int size;
	private LinkedList<Integer> adjList[];

	BFS(int capacity){
		size = capacity;
		adjList = new LinkedList[capacity];
		int iter = 0;
		while(iter < size){
			adjList[iter++] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v){
		adjList[u].addLast(v);
	}

	// connected graphs
	public void bfsConnected(){
		boolean visited[] = new boolean[size];
		int iter = 0, currNode = 0, node = 0;
		while(iter < size)
			visited[iter++] = false;

		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		if(size == 0)
			return;
		que.add(0);
		while(!que.isEmpty()){
			currNode = que.pop();
			System.out.println(currNode);

			visited[currNode] = true;
			Iterator<Integer> itr = adjList[currNode].listIterator();
			while(itr.hasNext()){
				node = itr.next();
				if(!visited[node]){
					que.push(node);
					visited[node] = true;
				}
			}
		}
	}

	//disconnected graphs
	public void bfsdisconnected(){
		boolean visited[] = new boolean[size];
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		int iter = 0, currNode = 0, node = 0;
		while(iter < size)
			visited[iter++] = false;

		if(size == 0)
			return;
		iter = 0;
		while(iter < size){
			if(!visited[iter]){
				que.add(iter);
				visited[iter] = true;

				while(!que.isEmpty()){
					currNode = que.pop();
					System.out.println(currNode);
					for(int i: adjList[currNode]){
						if(!visited[i]){
							que.add(i);
							visited[i] = true;
						}
					}
				}
			}
			iter++;
		}
	}

    public static void main(String... args){
    	BFS g = new BFS(7);

    	g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.bfsConnected();
        System.out.println("Disconnected Graphs");
        g.bfsdisconnected();
    }
}
