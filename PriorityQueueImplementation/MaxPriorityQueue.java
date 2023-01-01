package PriorityQueueImplementation;

import java.util.ArrayList;

public class MaxPriorityQueue {
		// Complete this class
		private ArrayList<Integer> heap;

		public MaxPriorityQueue() {
			heap = new ArrayList<Integer>();
		}
		boolean isEmpty() {
			// Implement the isEmpty() function here
			return heap.size() == 0;
		}

		int getSize() {
			// Implement the getSize() function here
			return heap.size();
		}

		int getMax() {
			// Implement the getMax() function here
			if (isEmpty()) {
				return Integer.MIN_VALUE;
			}
			return heap.get(0);
		}

		void insert(int element) {
			// Implement the insert() function here
			heap.add(element);
			int childIndex = heap.size() - 1;
			int parentIndex = (childIndex - 1) / 2;

			while (childIndex > 0) {
				if (heap.get(childIndex) > heap.get(parentIndex)) {
					int temp = heap.get(childIndex);
					heap.set(childIndex, heap.get(parentIndex));
					heap.set(parentIndex, temp);
					childIndex = parentIndex;
					parentIndex = (childIndex - 1) / 2;
				} else {
					return;
				}
			}
		}

		int removeMax() {
			// Implement the removeMax() function here
			if (isEmpty())
				return Integer.MIN_VALUE;
			int element = heap.get(0);
			heap.set(0, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);
			int size = heap.size();
			int index = 0;
			int maxindex = index;
			int child1 = 1;
			int child2 = 2;
			while (child1 < heap.size()) {
				if (heap.get(maxindex) < heap.get(child1)) {
					maxindex = child1;
				}
				if (child2 < heap.size() && heap.get(maxindex) < heap.get(child2)) {
					maxindex = child2;
				}
				if (maxindex == index) {
					break;
				} else {
					int temp = heap.get(index);
					heap.set(index, heap.get(maxindex));
					heap.set(maxindex, temp);
					index = maxindex;
					child1 = 2 * index + 1;
					child2 = 2 * index + 2;
				}
			}

			return element;
		}
	
}
