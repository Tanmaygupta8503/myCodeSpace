
public class QueueUse {
	public static void main(String args[])
	{
		QueueClassUsingLinkedList queue=new QueueClassUsingLinkedList();
		for(int i=1;i<=5;i++)
		{
			queue.enqueue(i);
		}
		while(!queue.isEmpty())
		{
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
