
public class StackUseClass
{
	
	public static void main(String args[]) throws StackFullException
	{
		StackUsingLinkedList stack=new StackUsingLinkedList();
		for(int i=1;i<=10;i++)
		{
			stack.push(i);
		}
		while(! stack.isEmpty())
		{
			try {
				System.out.println(stack.pop());
			} 
			catch (EmptyStackException e) {
				//never reach here
			}
		}
	}
}
