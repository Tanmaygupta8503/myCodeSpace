import linkedlist.Node;
public class QueueClassUsingLinkedList <T>{
	private int size;
	private Node<T> front;
	private Node<T> rear;
	public QueueClassUsingLinkedList() {
		front =null;
		rear=null;
		size=0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public T front() throws QueueEmptyException
	{
		if(size==0)
		{
			throw new QueueEmptyException();
		}
		return front.data;
	}
	public void enqueue(T element)
	{
		Node<T> newnode=new Node<>(element);
		if(size==0)
		{
			front=newnode;
			rear=newnode;
			size++;
		}
		else {
			rear.next=newnode;
			rear=rear.next;
			size++;
		}
	}
	public T dequeue() throws QueueEmptyException
	{
		if(size==0)
		{
			throw new QueueEmptyException();
		}
		T temp=front.data;
		front=front.next;
		if(size==1)
			rear=null;
		size--;
		return temp;
	}
	
}

