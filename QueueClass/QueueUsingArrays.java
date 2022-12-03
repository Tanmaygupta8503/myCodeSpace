
public class QueueUsingArrays {
	private int data[];
	private int front;
	private int rear;
	private int size;
	public QueueUsingArrays() {
		data=new int [10];
		front=-1;
		rear=-1;
		size=0;
	}
	public QueueUsingArrays(int capacity) {
		data=new int [capacity];
		front=-1;
		rear=-1;
		size=0;
	}
	int size()
	{
		return size;
	}
	boolean isEmpty()
	{
		return size==0;
	}
	int front() throws QueueEmptyException
	{
		if(size==0)
		{
			throw new  QueueEmptyException();
		}
		return data[front];
	}
	void enqueue(int element) throws QueuefullException
	{
		if(size==data.length)
		{
			//throw new  QueuefullException();
			doubleCapacity();
		}
		if(size==0)
			front=0;
		rear=(rear+1)%data.length;
		size++;
		data[rear]=element;
	}
	private void doubleCapacity()
	{
		int temp[]=data;
		data=new int[2*data.length];
		int index=0;
		for(int i=front;i<temp.length;i++)
		{
			data[index]=temp[i];
			index++;
		}
		for(int i=0;i<front;i++) {
			data[index]=temp[i];
			index++;
		}
		front=0;
		rear=temp.length-1;
	}
	int dequeue() throws QueueEmptyException
	{
		if(size==0)
		{
			throw new  QueueEmptyException();
		}
		int temp=data[front];
		front=(front+1)%data.length;
		size--;
		if(size==0)
		{
			front=-1;
			rear=-1;
		}
		return temp;
	}
}
