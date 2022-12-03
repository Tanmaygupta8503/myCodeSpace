
public class StackUsingArrays {
	private int data[];
	private int top; // index of top most element
	public StackUsingArrays() {
		data=new int [10];
		top=-1;
	}
	public StackUsingArrays(int capacity) {
		data=new int [capacity];
		top=-1;
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public Integer size()
	{
		return top+1;
	}
	public int top() throws EmptyStackException
	{
		if(size()==0)
		{
			//throws EmptyStackException
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		return data[top];
	}
	public void push(int elem) throws StackFullException
	{
		if(size()==data.length)
		{
			int newdata[]=new int[data.length*2];
			for(int i=0;i<data.length;i++)
			{
				newdata[i]=data[i];
			}
			data=newdata;
		}
		data[++top]=elem;
	}
	public int pop() throws EmptyStackException {
		if(size()==0)
		{
			//throws EmptyStackException
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		int temp=data[top--];
		return temp;
	}
}
