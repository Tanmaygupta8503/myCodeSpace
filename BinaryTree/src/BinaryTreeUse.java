import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class BinaryTreeUse {
	public static BinaryTreeNode<Integer> takeInput(Scanner sc)
	{
		int rootData;
		System.out.println("Input root data");
		rootData=sc.nextInt();
		if(rootData == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(sc);
		root.right=takeInput(sc);
		return root;
	}
	public static void printAtK(BinaryTreeNode<Integer> root , int k)
	{
		if(root == null ||k < 0)
		{
			return ;
		}
		if(root != null && k == 0)
		{
			System.out.println(root.data);
			return;
		}
		
		printAtK(root.left,k-1);
		printAtK(root.right,k-1);
	}
	public static BinaryTreeNode<Integer> takeInputLevelWise()
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter root.data");
		int rootdata=sc.nextInt();
		Queue <BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty())
		{
			BinaryTreeNode<Integer> front=pendingNodes.poll();
			System.out.println("Enter left child of "+ front.data);
			int leftchild=sc.nextInt();
			if(leftchild != -1)
			{
				BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(leftchild);
				pendingNodes.add(child);
				front.left=child;
			}
			System.out.println("Enter right child of "+ front.data);
			int rightchild=sc.nextInt();
			if(rightchild != -1)
			{
				BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(rightchild);
				pendingNodes.add(child);
				front.right=child;
			}	
		}
		return root;
	}
	public static void printTree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return ;
		String toBePrinted=root.data+"";
		if(root.left != null)
		{
			toBePrinted+=" L:"+ root.left.data +",";
		}
		if(root.right != null)
		{
			toBePrinted+=" R:"+ root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		// Your code goes here
		int a = print(root, k, node);
	}

	public static int print(BinaryTreeNode<Integer> root, int k, int data) {
		if (root == null)
			return -1;
		if (root.data == data) {
			printAtK(root, k);
			return 0;
		}
		int ld = print(root.left, k, data);
		int rd;
		if (ld == -1) {
			rd = print(root.right, k, data);
			if (rd == -1) {
				return -1;
			} else if (rd + 1 == k) {
				System.out.println(root.data);
				return k;
			} else {
				printAtK(root.left, k - rd - 2);
				return rd + 1;
			}
		} else if (ld + 1 == k) {
			System.out.println(root.data);
			return k;
		} else {
			printAtK(root.right, k - ld - 2);
			return ld + 1;
		}
	}


	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
		if(root==null)
		return false;
		if(root.data==x)
		return true;
		if(root.left!=null)
		return isNodePresent(root.left , x);
		if(root.right!=null)
		return isNodePresent(root.right, x);
		return false;
	}
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		return buildTree(preOrder, inOrder, 0, preOrder.length-1);
	}
	public static int search(int [] arr , int s , int  e ,int t)
	{
		for(int i=s ; i <= e ; i++)
		{
			if(arr[i] == t)
			{
				return i;
			}
		}
		return -1;
	}
	static int idx=0;
	public static BinaryTreeNode<Integer> buildTree1(int[] postOrder, int[] inOrder) {
		return buildTree1(inOrder, inOrder.length-1, 0, postOrder, postOrder.length-1);
	}

	private static BinaryTreeNode<Integer> buildTree1(int[] inorder , int inStart , int inEnd , int[] postorder , int postStart) {
		if (postStart < 0 || inStart < inEnd)
			return null;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode <>(postorder[postStart]);
		
		int rIndex = inStart;
		for (int i = inStart; i >= inEnd; i--) {
			if (inorder[i] == postorder[postStart]) {
				rIndex = i;
				break;
			}
		}
		root.right = buildTree1(inorder, inStart, rIndex + 1, postorder, postStart-1);
		root.left = buildTree1(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
		return root;
	}
	public static BinaryTreeNode<Integer> buildTree(int [] preorder , int [] inorder , int start , int end )
	{	
		
		if(start>end)
		return null;
		int curr = preorder[idx];
		idx ++;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(curr);
		if(start == end)
		return node;
		int pos = search(inorder , start , end , curr);
		node.left = buildTree(preorder , inorder , start ,pos-1);
		node.right = buildTree(preorder , inorder , pos+1 , end);
		return node;
	}
	public static BalancedTreeReturn BalancedTreeBetter(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			int height = 0;
			boolean isBal = true;
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.isBalanced = isBal ;
			ans.height = height;
			return ans;
		}
		BalancedTreeReturn leftOutput = BalancedTreeBetter(root.left);
		BalancedTreeReturn rightOutput = BalancedTreeBetter(root.right);
		 boolean isBal = true;
		 int height = 1 + Math.max(leftOutput.height , rightOutput.height); 
		 
		 if(Math.abs(leftOutput.height - rightOutput.height) > 1)
		 {
			 isBal = false;
		 }
		 
		 if(!leftOutput.isBalanced || !rightOutput.isBalanced)
		 {
			 isBal = false;
		 }
		 BalancedTreeReturn ans = new BalancedTreeReturn();
		 ans.height = height;
		 ans.isBalanced = isBal;
		 return ans;
	}
	public static int diameter(BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return 0;
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		return Math.max(option1 , Math.max(option2,option3));
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root == null) 
			return ;
			
		//String s="";
		Queue <BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		System.out.println(root.data+" ");
		while(!pendingNodes.isEmpty())
		{
			StringBuilder  s= new StringBuilder();
			int qs=pendingNodes.size();
			for(int i=0;i<qs;i++)
			{
				BinaryTreeNode<Integer> front = pendingNodes.poll();
				s.append("");
				if(front.left != null)
				{
					s.append(front.left.data+" ");
					pendingNodes.add(front.left);
				}
				if(front.right != null)
				{
					s.append(front.right.data+" ");
					pendingNodes.add(front.right);
				}
			}
			System.out.println(s.toString());
			
		}
	}


	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root == null){
			return;
		}
		 
		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		newNode.left=root.left;
		root.left = newNode;
		
	}
	
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root == null)
		{
			return ;
		}
		
		if(root.data > k1)
		{
			elementsInRangeK1K2(root.left , k1 ,k2);
		}
		if(root.data >= k1 && root.data <=k2 )
		System.out.print(root.data +" ");
		if(root.data < k2)
		{
			elementsInRangeK1K2(root.right ,k1 ,k2);
		}
	}
	public static boolean isBalanced(BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return true;
		int rightheight = height(root.right);
		int leftheight = height(root.left);
		if(Math.abs(leftheight-rightheight)>1)
		{
			return false;
		}
		boolean right=isBalanced(root.right);
		boolean left = isBalanced(root.left);
		return right && left;
	}
	public static BinaryTreeNode<Integer> removeleaves (BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
		{
			return null;
		}
		root.left = removeleaves(root.left);
		root.right= removeleaves(root.right);
		return root;
	}
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			Pair<Integer , Integer> output = new Pair<>();
			output.first=0;
			output.second = 0;
			return output;
		}
		
		Pair<Integer , Integer> lo = heightDiameter(root.left);
		Pair<Integer , Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first , ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1 , Math.max(option2, option3));

		Pair<Integer , Integer> output = new Pair<>();
		output.first=height;
		output.second = diameter;
		return output;
	}
	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
		int k = height(root);
		for (int i = 0; i < k; i++) {
			setAtK(root, i, i);
		}
	}
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		if(root == null)
		return ;
		    
		BinaryTreeNode<Integer> temp = root.left;     
		root.left=root.right;
		root.right=temp;             
		mirrorBinaryTree(root.left); 
		mirrorBinaryTree(root.right);
	}
	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if (root == null) {
			return 0;
		}
		int maxLen = 0;
		maxLen=Math.max(maxLen, Math.max(height(root.left),height(root.right)));
		
		return maxLen + 1;
	}
	public static boolean isBST(BinaryTreeNode<Integer> root) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		ArrayList<Integer> arr =new ArrayList<>();
		inorder(root , arr);
		ArrayList<Integer> sortarr =new ArrayList<>(arr);
		Collections.sort(sortarr);
		return sortarr.equals(arr);

	}
    
	
	public static void inorder(BinaryTreeNode<Integer> root ,ArrayList<Integer> arr)
	{
		if(root == null)
		{
			return ;
		}
		inorder(root.left ,arr);
		arr.add(root.data);
		inorder(root.right, arr);
	}
    
	public static ArrayList<Integer> getPathInBST(BinaryTreeNode<Integer> root, int data){
		
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		if(data < root.data)
		{
			ArrayList<Integer> leftOutput = getPathInBST(root.left, data);
			if (leftOutput != null) {
				leftOutput.add(root.data);
				return leftOutput;
			}
	    }
		if(root.data < data){
			ArrayList<Integer> rightOutput = getPathInBST(root.right, data);
			if (rightOutput != null) {
				rightOutput.add(root.data);
				return rightOutput;
			}
		} 
		return null;
	}
	
	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		
		ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		} else {
			return null;
		}
		
	}
    
    public static boolean isBST1(BinaryTreeNode<Integer> root){
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		if(root == null)
			return true;
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if(root.data <= leftMax || root.data > rightMin )
		return false;
		boolean leftValid = isBST1(root.left);
		boolean rightValid = isBST1(root.right);
		return leftValid && rightValid;  	
	}
    public static boolean isBST3(BinaryTreeNode <Integer> root  , int min ,int max)
	{ /*
		O(n) solution to check if binary tree is a BST
	*/
		if(root == null)
		return true;
		if(root.data < min || root .data >max)
		{
			return false;
		}
		boolean isLeftOk = isBST3 (root.left , min ,root.data-1);
		boolean isRightOk = isBST3(root.right , root.data , max);
		return isLeftOk && isRightOk;
	} 
	public static int minimum (BinaryTreeNode <Integer> root )
	{
		if(root == null )
		{
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data , (Math.min(minimum(root.left) , minimum(root.right))));
	}
	public static int maximum (BinaryTreeNode <Integer> root )
	{
		if(root == null )
		{
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data , (Math.max(maximum(root.left) , maximum(root.right))));
	}
	public static void setAtK(BinaryTreeNode<Integer> root, int k, int set) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			root.data = set;
			return;
		}
		if(root.left!=null)
		{
			setAtK(root.left ,k-1,set);
		}
		if(root.right != null)
		{
			setAtK(root.right , k-1 , set);
		}
	}
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
			//Your code goes here
		if (root == null)
			 return 0;
		 int count = 0;
		 if (root.data > x)
			 count++;
		 count+=countNodesGreaterThanX(root.left,x);
		 count+=countNodesGreaterThanX(root.right,x);
		 return count;
	}		
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root.left == null && root.right != null)
		{
			System.out.print(root.right.data + " ");
		}
		if(root.right == null && root.left != null)
		{
			System.out.print(root.left.data + " ");
		}
		if(root.left != null)
		printNodesWithoutSibling(root.left);
		if(root.right != null)
		printNodesWithoutSibling(root.right);
	}
	static int sum=0;
	public static int getSum(BinaryTreeNode<Integer> root) {
			//Your code goes here.
		if (root == null)
			return 0;
		int sum = root.data;
		sum+=getSum(root.left);
		sum+=getSum(root.right);
		return sum;			
	}
	 
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return SortedArrayToBST(arr ,0 ,arr.length-1);
	}
	public static BinaryTreeNode<Integer>  SortedArrayToBST(int arr[] , int si , int ei)
	{
		if(si > ei)
		return null;
		int mid= (ei + si) / 2;
		BinaryTreeNode<Integer> newnode = new BinaryTreeNode<>(arr[mid]);
		newnode.left = SortedArrayToBST(arr ,si, mid-1);
		newnode.right = SortedArrayToBST(arr , mid+1 , ei);
		return newnode;
	}
	
	
/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

	public static void pairSum(BinaryTreeNode<Integer> root, int sum) {

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		ArrayList<Integer> arr =new ArrayList<>();
		inorder(root , arr);
		Collections.sort(arr);
		twoSum(arr , sum);
	}
//	private static void inorder(BinaryTreeNode<Integer> root ,ArrayList<Integer> arr)
//	{
//		if(root == null)
//		{
//			return ;
//		}
//		inorder(root.left ,arr);
//		arr.add(root.data);
//		inorder(root.right, arr);
//	}
	private static void twoSum(ArrayList<Integer> arr, int x) {
        int lo = 0, hi = arr.size() -1;
		while(lo < hi) {
			int sum = arr.get(lo) + arr.get(hi);
			if(sum > x)
				hi--;
			else if(sum < x)
				lo++;
			else {
				System.out.println(arr.get(lo) + " " + arr.get (hi));
				lo ++;
				hi --;
			}
		}
    }


	
	public static void main(String[] args) {
		int arr[] = {2,3,5,9,10,15,18,29};
		BinaryTreeNode<Integer> bst= SortedArrayToBST(arr , 8);
		printTree(bst);
		print(bst, 2, 9);
//		System.out.println(height(bst));
 		Scanner sc=new Scanner (System.in);
//		BinaryTreeNode<Integer> root =takeInput(sc);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		insertDuplicateNode(root);
		printTree(root);
		//System.out.println("Diameter of tree = "+diameter(root));
		System.out.println(BalancedTreeBetter(root).isBalanced);
		System.out.println("Diameter of tree is -->" + heightDiameter(root).second);
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<> (1);
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer> (2);
//		root.left = node1;
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer> (3);
//		root.right = node2;
		sc.close();
	}
}
