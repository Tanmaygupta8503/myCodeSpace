import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(20);
		queue.add(10);
		queue.add(50);
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		queue.poll();
		queue.poll();
		System.out.println(queue.peek());
	}

}
