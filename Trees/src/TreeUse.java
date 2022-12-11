import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class TreeUse {

	public static TreeNode<Integer> takeInput(Scanner sc)
	{
		int n;
		System.out.println("Enter next node data");
		n=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<>(n);
		System.out.println("Enter no of children for "+n);
		int childCount=sc.nextInt();
		for(int i=0;i<childCount;i++)
		{
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	public static int height(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int maxLen=0;
		for(TreeNode<Integer> child : root.children)
		{
			maxLen=Math.max(maxLen, height(child));
		}
		return maxLen+1;
	}
	public static TreeNode<Integer> takeInputLevelWise()
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter root.data");
		int rootdata=sc.nextInt();
		Queue <TreeNode<Integer>> pendingNodes = new LinkedList<>();
		TreeNode<Integer> root=new TreeNode<Integer>(rootdata);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty())
		{
			TreeNode<Integer> frontNode=pendingNodes.poll();
			System.out.println("Enter number of children of "+ frontNode.data);
			int numChildren=sc.nextInt();
			for(int i=0;i<numChildren;i++)
			{
				System.out.println("Enter "+ (i+1) + "th child of " + frontNode.data);
				int child=sc.nextInt();
				TreeNode<Integer>childNode=new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		return root;
	}
	public static void printLevelWise(TreeNode<Integer> root)
	{
		if(root == null) 
			return ;
			
		//String s="";
		Queue <TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty())
		{
			String s="";
			int qs=pendingNodes.size();
			for(int i=0;i<qs;i++)
			{
				TreeNode<Integer> front = pendingNodes.poll();
				s+=front.data+" ";
				for(TreeNode<Integer> child:front.children)
				{
					pendingNodes.add(child);
				}
			}
			System.out.println(s);
		}
	}
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		// Write your code here		
		 if (root == null)
			 return 0;
		 int count = 0;
		 if (root.data > x)
			 count++;
		 for(TreeNode<Integer> child : root.children)
		 {
			 count += numNodeGreater(child, x);
		 }
		 return count;
	}
	public static void printAtK(TreeNode<Integer> root , int k)
	{
		if(k<0)
		{
			return ;
		}
		if(k == 0)
		{
			System.out.println(root.data);
			return;
		}
		for(int i = 0; i < root.children.size();i++)
		{
			printAtK(root.children.get(i),k-1);
		}
	}
	public static int largestNode(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		int ans=root.data;
		for(int i=0;i < root.children.size();i++)
		{
			int childLargest=largestNode(root.children.get(i));
			if(childLargest>ans)
				ans=childLargest;
		}
		return ans;
	}
	public static void print(TreeNode<Integer> root)
	{
		String s=root.data+":";
		for(int i=0;i<root.children.size();i++)
		{
			s=s+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++)
		{
			print(root.children.get(i));
		}
	}
	public static int numNodes(TreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		int count=1;
		for(int i=0;i<root.children.size();i++)
		{
			count+=numNodes(root.children.get(i));
		}
		return count;
	}
	public static int sumOfAllNode(TreeNode<Integer> root){
		if(root==null)
		return 0;
		int sum=root.data;
		for(int i=0;i<root.children.size();i++)
		{
			sum+=sumOfAllNode(root.children.get(i));
		}
		return sum;
	}
	public static void preorder(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print((root.data)+" ");
		for(int i=0;i<root.children.size();i++)
		{
			preorder(root.children.get(i));
		}
	}
	public static void postorder(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return ;
		}
		for(TreeNode<Integer> child:root.children)
		{
			postorder(child);
		}
		System.out.println(root.data);
	}
	public static void main(String[] args) {
//		TreeNode<Integer> root=new TreeNode<Integer>(4);
//		TreeNode<Integer> node1=new TreeNode<Integer>(2);
//		TreeNode<Integer> node2=new TreeNode<Integer>(3);
//		TreeNode<Integer> node3=new TreeNode<Integer>(5);
//		TreeNode<Integer> node4=new TreeNode<Integer>(6);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		System.out.println(root);
		Scanner sc=new Scanner (System.in);
		TreeNode<Integer> root=takeInput(sc);
//		TreeNode<Integer> root=takeInputLevelWise();
		printLevelWise(root);
//		print(root);
		System.out.println("Enter the value for which you want count of node grater than 'X");
		int x=sc.nextInt();
		System.out.println("Enter value for which you want the display of all nodes at level 'K");
		int k=sc.nextInt();
		System.out.println("number of Nodes ->"+numNodes(root));
		System.out.println("sumOfAllNodes -> "+sumOfAllNode(root));
		System.out.println("Largest Node ->"+ largestNode(root));
		System.out.println("Nodes grater than "+x+" are "+numNodeGreater(root, x));
		System.out.println("Printing All Nodes At "+k);
		printAtK(root, k);
		System.out.println("preorder");
		preorder(root);
		System.out.println("postorder");
		postorder(root);
		System.out.println("Height of tree is "+height(root));
		System.out.println();
	}
}
