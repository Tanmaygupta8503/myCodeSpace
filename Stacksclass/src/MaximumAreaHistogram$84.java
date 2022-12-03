import java.util.Stack;

public class MaximumAreaHistogram$84 {
	    public static int largestRectangleArea(int[] heights) {
	        int left[]=nextSmallerLeft(heights);
	        int right[]=nextSmallerRight(heights);
	        for(int i:left)
	        	System.out.print(i+" ");
	        System.out.println();
	        for(int i:right)
	        	System.out.print(i+" ");
	        System.out.println();
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<heights.length;i++)
	        {
	            max=Math.max(max,((left[i]-
                right[i]-1)*heights[i]));
	        }
	        return max;
	    }
	    public static int [] nextSmallerLeft(int arr[])
		{
			Stack<Integer> stack=new Stack<>();
			int res[]=new int [arr.length];
			for(int i=arr.length-1;i>=0;i--)
			{
				while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				{
					stack.pop();
				}
				if(stack.isEmpty())
				{
					res[i]=arr.length;
				}
				else {
					res[i]=stack.peek();
				}
				stack.push(i);
			}
			return res;
			
		}
	    public static int [] nextSmallerRight(int arr[])
		{
			Stack<Integer> stack=new Stack<>();
			int res[]=new int [arr.length];
			for(int i=0;i<=arr.length-1;i++)
			{
				while(!stack.isEmpty() && arr[stack.peek()]  >= arr[i])
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
				stack.push(i);
			}
			return res;
		}
	    public static void main(String args[])
	    {
	    	int arr[]= {2,1,5,6,2,3};
	    	System.out.println(largestRectangleArea(arr));
	    }
	
}