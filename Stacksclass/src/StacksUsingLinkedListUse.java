
public class StacksUsingLinkedListUse {

	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack =new StackUsingLinkedList<>();
		for(Integer i=1;i<=5;i++)
		{
			stack.push(i);
		}
		while(!stack.isEmpty())
		{
			try {
				System.out.println(stack.pop());
			} catch (EmptyStackException e) {
				//never coming in here
			}
		}
	}

}
