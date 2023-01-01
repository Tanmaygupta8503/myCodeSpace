package PriorityQueueImplementation;

public class PriorityQueueUse {
	public static void main(String[] args) throws PriorityQueueEmptyException {
		PriorityQueue pq = new PriorityQueue();
		int arr [] = {5,6,7,4,3,7,4};
		for(int i: arr)
		{
			pq.insert(i);
		}
		while(!pq.isEmpty())
		{
			System.out.print(pq.removeMin()+" ");
		}
	}
}
