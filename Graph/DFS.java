import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;


public class DFS {

	private int size;
	private LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked") DFS(int capacity){
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

	//connected graphs
	public void dfsConnected(int index, boolean[] visited){
		if(visited[index])
			return;

		visited[index] = true;
		System.out.print(index + " ");
		Iterator<Integer> itr = adjList[index].listIterator();
		while(itr.hasNext()){
			int node = itr.next();
			if(!visited[node])
				dfsConnected(node, visited);
		}
	}

    public static void main(String... args){
    	DFS g = new DFS(7);

    	g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        boolean[] visited = new boolean[7];
        g.dfsConnected(1, visited);
        System.out.println("Disconnected Graphs");
        int iter = 0;
        while(iter < 7){
        	visited[iter++] = false;
        }
        iter = 0;
        while(iter < 7){
        	g.dfsConnected(iter, visited);
        	iter++;
        }
    }
}
