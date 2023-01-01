package PriorityQueueImplementation;
import java.util.ArrayList;

public class PriorityQueue {
	
	private ArrayList<Integer> heap;
	public PriorityQueue() {
		heap = new ArrayList<>();
	}
	boolean isEmpty()
	{
		return heap.size() == 0;
	}
	int size()
	{
		return heap.size();
	}
	int getMin() throws Exception
	{
		if(isEmpty())
		{
			//throws PriorityQueueEmptyException
			throw new Exception();
		}
		return heap.get(0);
	}
	void insert(int element)
	{
		heap.add(element);
		int childIndex = heap.size()-1;
		int parentIndex =(childIndex - 1 ) / 2;
		while(childIndex > 0)
		{
			if(heap.get(childIndex) < heap.get(parentIndex))
			{
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
			else {
				return ;
			}
		}
	}
	int removeMin() throws PriorityQueueEmptyException{
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
		if(isEmpty())
		throw new PriorityQueueEmptyException();
		int element = heap.get(0);
		heap.set( 0 , heap.get(heap.size() - 1));
		heap.remove(heap.size()-1);
		int index = 0;
		int minindex = index;
		int child1 = 1;
		int child2 = 2;
		while(child1 < heap.size()){
			if(heap.get(minindex) > heap.get(child1))
			{
				minindex=child1;
			} 
			if(child2<heap.size() && heap.get(minindex) > heap.get(child2))
			{
				minindex = child2;
			}
			if(minindex  == index){
				break;
			}
			else{
				int temp = heap.get(index);
				heap.set(index , heap.get(minindex));
				heap.set(minindex , temp);
				index = minindex;
				child1 = 2*index+1;
				child2 = 2*index+2;
			}
		}

		return element;
	}
}

