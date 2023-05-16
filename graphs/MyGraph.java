package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {
	static class Edge{
		int src;
		int dest;
		int wt;
		public Edge(int s, int d , int wt) {
			this.src = s;
			this.dest = d;
			this.wt = wt;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i = 0 ; i < graph.length ; i ++) {
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0 , 1 , 10));
		graph[0].add(new Edge(0 , 3 , 30));
		graph[0].add(new Edge(0 , 2 , 15));
		
		graph[1].add(new Edge(1 , 2 , 40));
		graph[1].add(new Edge(1 , 0 , 10));
//		graph[1].add(new Edge(1 , 4));
		
		graph[2].add(new Edge(2 , 1 , 0));
		graph[2].add(new Edge(2 , 0 , 15));
//		graph[2].add(new Edge(2 , 3 , 50));
		
		graph[3].add(new Edge(3 , 4 , 40));
		graph[3].add(new Edge(3 , 0 , 30));
//		graph[3].add(new Edge(3 , 5 , 50));
		
//		graph[4].add(new Edge(4 , 5 , 5));
		graph[4].add(new Edge(4 , 3 , 5));
//		graph[4].add(new Edge(4 , 5));
		
//		graph[5].add(new Edge(5 , 3 , 0));
//		graph[5].add(new Edge(5 , 4 , 0));
//		graph[5].add(new Edge(5 , 5));
//		
//		graph[5].add(new Edge(6 , 5));
		
		
//		graph[0].add(new Edge(0,2));
//		graph[1].add(new Edge(1,0));
//		graph[2].add(new Edge(2,3));
//		graph[3].add(new Edge(3,0));
		
//		graph[2] .add(new Edge(2,3));
//		graph[3] .add(new Edge(3,1));
//		graph[4] .add(new Edge(4,0));
//		graph[4] .add(new Edge(4,1));
//		graph[5] .add(new Edge(5,0));
//		graph[5] .add(new Edge(5,2));

	}
	  
	public static class Pair implements Comparable<Pair>{
		int node , dist;
		public Pair(int n , int d) {
			this.node = n;
			this.dist = d;
		}
		@Override
		public int compareTo(Pair p2) {
			return this.dist - p2.dist;
		}
	}
	
	
	public static int primsAlgo(ArrayList<Edge> [] graph , int V) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean vis[] = new boolean [V];
		pq.add(new Pair(0 , 0));
//		int sv = 0;
//		ArrayList<Edge>[]mst = new ArrayList[V];
//		for(int i = 0 ; i < V ;i ++) {
//			mst[i] = new ArrayList<Edge>();
//		}
		int cost = 0 ;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
//			sv = curr.node;
			if(!vis[curr.node]) {
				vis[curr.node] = true;
				cost += curr.dist;
//				mst[sv].add(new Edge(sv , curr.node , curr.dist));
				for(Edge e : graph[curr.node]) {
//					sv = e.dest;
					if(!vis[e.dest]) {
						pq.offer(new Pair(e.dest , e.wt));
					}
				}
			}
		}
//		for(ArrayList<Edge> arr: mst) {
//			for(Edge e : arr) {
//				System.out.println(e.src+ " " +e.dest+ " "  + " " + e.wt);
//			}
//		}
		return cost;
	}
	
	
	
	public static void dijkstra(ArrayList<Edge> graph[] ,int src , int V)  {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int dist [] = new int [V];
		boolean vis [] = new boolean[V];
		for(int i = 0 ; i < V ; i ++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		pq.add(new Pair(0 , 0));
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			if(!vis[curr.node]) {
				vis[curr.node] = true;
				for(Edge e : graph[curr.node]) {
					int u = e.src , v = e.dest;
					if(dist[u] + e.wt < dist[v]) {
						dist[v] = e.wt + dist[u];
						pq.add(new Pair(v , dist[v]));
					}
				}
			}
		}
		for(int  i : dist) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	public static boolean isCycleDirected(ArrayList<Edge> graph[] , boolean vis[] , int curr , boolean rec[]) {
		vis[curr] = true;
		rec[curr] = true;
		for(int i = 0 ; i < graph[curr].size(); i ++) {
			Edge e = graph[curr].get(i);
			if(rec[e.dest] == true) {
				return true; // cycle condition
			}
			else if(!vis[e.dest]) {
				if(isCycleDirected(graph, vis, e.dest, rec))
					return true;	
			}
		}
		rec[curr] = false;
		return false;
	}
	
	public static void BFS(ArrayList<Edge> graph[] , int v , boolean vis[] , int start) {
		Queue<Integer> q= new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(!vis[curr])
			{
				System.out.print(curr + " ");
				vis[curr] = true;
			
				for(Edge e : graph[curr])
				{
					q.offer(e.dest);
				}
			}
			// 0(V+E)
		}
	}
	
	
	public static void DFS(ArrayList<Edge> graph[] , int curr , boolean[] vis) {
		System.out.print(curr+" ");
		vis[curr] = true;
		for(Edge e : graph[curr])
		{
			if(!vis[e.dest]) {
				DFS(graph , e.dest , vis);
			}
		}
	}
	
	
	public static void kosarajuAlgo(ArrayList<Edge> graph[] , int V) {
		// Step 1 : topSort
		Stack<Integer> s = new Stack<>();
		boolean vis [] = new boolean[V];
		for(int i = 0 ; i < V ; i ++) {
			if(!vis[i]) {
				topSortUtil(graph , vis , i , s);
			}
		}
		// Step 2 : Transpose of Graph
		ArrayList<Edge> transpose[] = new ArrayList[V];
		for(int i = 0 ; i < V ; i ++) {
			vis[i] = false;
			transpose[i] = new ArrayList<Edge>();
		}
		for(int i = 0 ; i < V ; i ++) {
			for(Edge e : graph[i]) {
				transpose[e.dest].add(new Edge(e.dest , e.src , 0));
			}
		}
		 
		// Step 3 : do DFS
		
		while(!s.isEmpty()) {
			int curr = s.pop();
			if(!vis[curr]) {
				DFS(transpose, curr, vis);
				System.out.println();
			}
		}
	}
	
	
	public static void printAllPaths(ArrayList<Edge> graph[] , int curr , boolean[] vis ,String path , int tar) {
		if(curr == tar) {
			System.out.println(path);
			return;
		}
		
		for(Edge e : graph[curr])
		{
			if(!vis[e.dest]) {
				vis[curr] = true;
				printAllPaths(graph , e.dest , vis ,path+e.dest , tar);
				vis[curr] = false;
			}
		}
	}
	
	
	public static void bellmanFord(ArrayList<Edge> graph[] , int src, int V) {
		int dist [] = new int [V];
		for(int i = 0 ; i < V ; i ++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		for(int k = 0 ; k < V ; k ++) {
			for(int  i = 0 ; i < V ; i++) {
				for(Edge e :graph[i]) {
					int u = e.src;
					int v= e.dest;
					if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u]+e.wt) {
						dist[v] = dist[u]+e.wt;
					}
				}
			}
		}
		
		// detect negative weight cycle
		for(int  i = 0 ; i < V ; i++) {
			for(Edge e :graph[i]) {
				int u = e.src;
				int v= e.dest;
				if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u]+e.wt) {
				System.out.println("Negative Weight Cycle");
				}
			}
		}
		for(int i : dist) {
			System.out.print(i+" "); 
		}
		System.out.println();
	}
	
	
	
	// O(e + v) 
	public static boolean isCycleUnDirected(ArrayList<Edge> graph[] , boolean vis[] , int curr , int par) {
		vis[curr] = true;
		for(Edge e : graph[curr]) {
			if(vis[e.dest] && par != e.dest) {
				return true;
			}
			else if(!vis[e.dest]){
				if(isCycleUnDirected(graph, vis, e.dest ,  curr))
					return true;
			}
		}
		return false;
	}
	
	
	public static void topSort(ArrayList<Edge> graph[] , int v) {
		boolean vis[] = new boolean [v]; 
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < v ; i ++) {
			if(!vis[i]) {
				topSortUtil(graph , vis , i , stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	
	private static void topSortUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack) {
		vis[curr] = true;
		for(Edge e : graph[curr]) {
			if(!vis[e.dest]) {
				topSortUtil(graph, vis, e.dest, stack);
			}
		}
		stack.push(curr);
	}


	public static void main(String[] args) {
		int v = 5;
				/*
				 * 0 -- 1 --- 2
			 	 * 	\  /      |
				 * 	 4        3
				 *    \ 
				 *     5
				 * 
				 */
		/*
		 * 
		 * 
		 * 		2 ----> 3 ----> 1
		 * 		^				^
		 * 		|				|
		 * 		|				|
		 * 		5 ----> 0 <---- 4
		 * 		 
		 */
	/*  
	    1-----3
	   /      | \
	  0	      |  5---6
	   \      | /
	    2 ----4
	    
	*/
		ArrayList<Edge> []graph = new ArrayList[v]; 
		createGraph(graph);
		getArticulationPoint(graph , v);
		getBridge(graph , v);
		kosarajuAlgo(graph, v);
		System.out.println(primsAlgo(graph, v));
		bellmanFord(graph, 0, v);
		System.out.println(isCycleUnDirected(graph, new boolean[v], 0, -1));
		dijkstra(graph, 0, v);
		topSort(graph, v);
		boolean vis[] = new boolean[v];
		boolean rec[] = new boolean[v];
//		for(int i = 0 ; i < v ; i ++ ) {
//			if(!vis[i])
//			BFS(graph, v , vis , i);
//		}
//		boolean vis[] = new boolean[v];
		for(int i = 0 ; i < v ; i ++ ) {
			if(!vis[i]) {
				boolean isCycle = isCycleDirected(graph, vis, 0, rec);
				if(isCycle)
				{
					System.out.println("isCycle");
					break;
				}
			}
		}
		int src = 0,tar = 5;
		printAllPaths(graph, 0, vis, "0", tar);
//		System.out.println("\"aditya\"");
	}



	private static void getArticulationPoint(ArrayList<Edge>[] graph, int V) {
		int dt[] = new int[V];
		int low [] = new int [V];
		int time = 0;
		boolean vis[] = new boolean[V];
		boolean ap[] = new boolean[V];
		
		for(int i = 0 ; i < V ; i ++) {
			if(!vis[i])
				DFSArticulationPoint(graph , i , -1 , dt , low , vis , time , ap);
		}
		for(int i = 0 ; i < V ; i ++) {
			if(ap[i])
				System.out.println("AP = "+i);
		}
	}



	private static void DFSArticulationPoint(ArrayList<Edge>[] graph, int curr, int par , int[] dt, int[] low, boolean[] vis,
			int time, boolean[] ap) {
		vis[curr] = true;
		dt[curr] = low [curr] = ++ time;
		int children = 0;
		
		for(Edge e :graph[curr]) {
			int neigh = e.dest;
			if(par == neigh) {
				continue;
			}
			else if(vis[neigh]) {
				low[curr] = Math.min(low[curr], dt[neigh]);
			}
			else {
				DFSArticulationPoint(graph, neigh, curr , dt, low, vis, time, ap);
				low[curr] = Math.min(low[curr], low[neigh]);
				if(dt[curr] <= low[neigh] && par != -1) {
					ap[curr] = true;
				}
				children ++;
			}
		}
		if(par == -1 && children > 1) {
			ap[curr] = true;
		}
	}



	private static void getBridge(ArrayList<Edge>[] graph, int V) {
		int dt[] = new int [V];
		int low [] = new int [V];
		int time = 0;
		boolean vis[] = new boolean[V];
		for(int i = 0 ; i < V ;i ++){
			if(!vis[i]) {
				dfsModified(graph , i , vis , dt , low , time , -1);
			}
		}
	}



	private static void dfsModified(ArrayList<Edge>[] graph,
		int curr, boolean[] vis, int[] dt,int[] low, int time, int par) {
		
		vis[curr] = true;
		dt[curr] = low[curr] = ++ time;
		
		for(Edge e : graph[curr]) {
//			System.out.println("DT");
//			for(int i : dt) {
//				System.out.print(i +  " ");
//			}
//			System.out.println();
//			System.out.println(curr + "," + e.dest);
//			System.out.println();
//			for(boolean i : vis) {
//				System.out.print(i+" ");
//			}
//			System.out.println("\n"+"LOW");
//			for(int i : low) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
			if(e.dest == par) {
				continue;
			}	
			else if(!vis[e.dest]) {
				dfsModified(graph, e.dest, vis, dt, low, time, curr);
				low[curr] = Math.min(low[curr], low[e.dest]);
				
				if(dt[curr] < low[e.dest]) {
					System.out.println("Bridge is" + " " + curr + " ---- " + e.dest);
				}
			}	
			else {
				low[curr] = Math.min(low[curr], dt[e.dest]);  
			}
		}
	}
}
