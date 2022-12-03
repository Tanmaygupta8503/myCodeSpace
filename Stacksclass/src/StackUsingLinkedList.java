import linkedlist.Node;
public class StackUsingLinkedList <T>{
	private Node<T> head;
	private int size=0;
	public StackUsingLinkedList() {
		head=null;
		size=0;
	}
	int size()
	{
		return size;
	}
	public T top() throws EmptyStackException
	{
		if(size()==0)
		{
			//throws StackEmptyException
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		return (T) head.data;
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public void push(T elem)
	{
		Node<T> newNode=new Node<T>(elem);
		newNode.next=(Node<T>) head;
		head=(Node<T>) newNode;
		size++;
	}
	public T pop() throws EmptyStackException
	{
		if(size()==0)
		{
			//throws StackEmptyException
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		size--;
		T temp=(T) head.data;
		head=head.next;
		return temp;
	}
}




