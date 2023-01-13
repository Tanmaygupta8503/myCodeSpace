package graphs;
import java.util.Scanner;
/*
				  DFS
				  printing
				  in a graph
				  
				     0     3
				    / \     \
				   1   2     4
				   
				   input:	output:
				   
				   n = 5	0
				   e = 4	1
				   0 1		2
				   1 2		3
				   0 2		4
				   3 4
				   
 */
public class Graphs {
	public static void printHelper(int edge[][] , int sv , boolean visited[])
	{
		System.out.println(sv);
		visited[sv] = true;
		int n = edge.length;
		for(int i = 0 ;i < n ; i ++) {
			if(! visited[i] && edge[sv][i] == 1) {
				printHelper(edge , i ,visited);
			}
		}
	}
	public static void print (int edge[][]) {
		
		boolean visited[] = new boolean[edge.length];
		for(int i = 0 ; i < edge.length ; i ++) {
			if(! visited[i])
			printHelper(edge , i , visited);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int edge[][] = new int[n][n];
		for(int i = 0 ; i < e ; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edge[fv][sv] = 1;
			edge[sv][fv] = 1;
		}
		print(edge);
		sc.close();
	}
}
