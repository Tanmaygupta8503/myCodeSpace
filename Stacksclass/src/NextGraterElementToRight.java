import java.util.Stack;

public class NextGraterElementToRight {
public static int [] nextGrater(int arr[])
{
	Stack<Integer> stack=new Stack<>();
	int res[]=new int [arr.length];
	for(int i=arr.length-1;i>=0;i--)
	{
		while(!stack.isEmpty() && stack.peek() <= arr[i])
		{
			stack.pop();
		}
		if(stack.isEmpty())
		{
			res[i]=-1;
		}
		else {
			res[i]=stack.peek();
		}
		stack.push(arr[i]);
	}
	return res;
}
public static void main(String args[])
{
	int arr[]= {1,2,3,3,4,54,3,4,5};
	int res[]=nextGrater(arr);
	for(int i:res)
	{
		System.out.println(i);
	}
}
}
