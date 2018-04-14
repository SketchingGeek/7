/* Assignment: 
 * Author: Jennifer N. Smith
 * Date:
 * Reference: 
 */

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<? super T>> {

	private ArrayList<T> arrayHeap = new ArrayList<>();

	public void add(T t) {
		arrayHeap.add(t);
		siftUp();
		return;
	}

	private void siftUp() {
		int p = arrayHeap.size() - 1;
		while (p != 0) {
			int parent = (p - 1) / 2;
			if (arrayHeap.get(p).compareTo(arrayHeap.get(parent)) >= 0) {
				return;
			} else {
				T temp = arrayHeap.get(parent);
				arrayHeap.set(parent, arrayHeap.get(p));
				arrayHeap.set(p, temp);
				p = parent;

			}
		}
	}

	public boolean isEmpty() {
		return arrayHeap.isEmpty();
	}

	public T poll() {
		if (isEmpty()) {
			return null;
		} else {
			T val = arrayHeap.get(0);
			arrayHeap.set(0, arrayHeap.get(arrayHeap.size() - 1));
			arrayHeap.remove(arrayHeap.size() - 1);
			siftDown();
			return val;
		}

	}

	private void siftDown() {
		int p = 0;
		int size = arrayHeap.size();
		while (2 * p + 1 < size) {
			int leftChildPos = 2 * p + 1;
			int rightChildPos = leftChildPos + 1;
			int minChildPos = leftChildPos;
			if (rightChildPos < size) {
				if (arrayHeap.get(rightChildPos)
						.compareTo(arrayHeap.get(leftChildPos)) < 0) {
					minChildPos = rightChildPos;
				}
			}
			if (arrayHeap.get(p).compareTo(arrayHeap.get(minChildPos)) <= 0) {
				break;
			} else {
				T temp = arrayHeap.get(p);
				arrayHeap.set(p, arrayHeap.get(minChildPos));
				arrayHeap.set(minChildPos, temp);
			}
			p = minChildPos;
		}
	}

}
