import java.util.Stack;

public class OnlineStockSpan$901 {
	public OnlineStockSpan$901() {
		
	}
	public static int [] stockspan(int arr[])
	{
		Stack<Integer> stack=new Stack<>();
		int res[]=new int [arr.length];
		for(int i=0;i<=arr.length-1;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
			{
				stack.pop();
			}
			if(stack.isEmpty())
			{
				res[i]=i+1;
			}
			else {
				res[i]=i-stack.peek();
			}
			stack.push(i);
		}
		return res;
	}
	public static void main(String args[])
	{
		int arr []= {10,4,5,90,120,80};
		int span[]=stockspan(arr);
		for(int i:span)
			System.out.print(i+" ");
	}
}
