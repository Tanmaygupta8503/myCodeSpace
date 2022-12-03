
public class StackUsingTwoQueuesUse {

	public static void main(String[] args) {
		StackUsingTwoQueues stack = new StackUsingTwoQueues();
		for(int i=1;i<=5;i++)
			stack.push(i);
		
		while(! stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}

}
