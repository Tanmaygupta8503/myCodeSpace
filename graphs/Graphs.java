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
