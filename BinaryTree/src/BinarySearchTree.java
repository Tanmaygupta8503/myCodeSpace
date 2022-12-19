
public class BinarySearchTree {
	private BinaryTreeNode<Integer> root;

	public void insert(int data) {
		//Implement the insert() function
		root = insert(root, data);
	}
	private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root , int data)
	{
		if(root == null)
		{
			BinaryTreeNode<Integer> newnode = new BinaryTreeNode<>(data);
			return newnode;
		}
		if(root .data >= data)
		{
			root.left=insert(root.left , data);
		}
		else{
			root.right=insert(root.right ,data);
		}
		return root;
	}
	public void remove(int data) {
		//Implement the remove() function
		root = remove(root , data);
	}
	private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root , int data)
	{
		if(root == null )
			return null ;
		if(root .data <data)
		{
			root.right = remove(root.right , data);
			return root;
		}
		else if(root.data > data)
		{
			root.left = remove(root.left , data);
			return root;
		}
		else  //if(root.data == data)
		{
			if(root.left ==null && root.right == null)
			{
				return null;
			}
			if(root .left == null)
			{
				return root.right;
			}
			if(root.right == null)
			{
				return root.left;
			}
			else{
				BinaryTreeNode<Integer> minnode = root.right;
				while(minnode.left != null)
				{
					minnode = minnode.left;
				}
				root.data = minnode.data;
				root.right = remove(root.right , minnode.data);
				return root;
			}
		}
	}
	public void printTree() {
		//Implement the printTree() function
		printTree(root);
	}
	private void printTree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return ;
		String toBePrinted=root.data+":";
		if(root.left != null)
		{
			toBePrinted+="L:"+ root.left.data +",";
		}
		if(root.right != null)
		{
			toBePrinted+="R:"+ root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public boolean search(int data) {
		//Implement the search() function
		return search(root, data);
	}
	private boolean search(BinaryTreeNode <Integer> root ,int x )
	{
		if(root==null)
		return false;
		if(root.data==x)
		return true;
		if(root.left!=null)
		return search(root.left , x);
		if(root.right!=null)
		return search(root.right, x);
		return false;
	}

}