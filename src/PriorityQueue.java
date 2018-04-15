
/* Assignment: CS1120 LA7 Course Registration System
 * Author: Jennifer N. Smith
 * Date: 4/14/18
 * Reference: LA7_Spring2018.docx (LA7 Instructions)
 */

import java.util.ArrayList;

/**
 * Priority queue implemented using linked lists
 * 
 * @author Jennifer Smith
 *
 * @param <E>
 *            type of data in the queue
 */
public class PriorityQueue<E extends Comparable<? super E>> {
	Node<E> head = null;

	/**
	 * Determine if the priority queue is empty.
	 * 
	 * @return true if the queue is empty
	 */

	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Add object added to the priority queue taking into consideration the
	 * rules governing priority.
	 * 
	 * @param data
	 *            to be added to the queue
	 */

	public void enqueue(E data) {
		Node<E> next = head;
		Node<E> prev = null;

		while (next != null) {
			if (next.getData().compareTo(data) > 0) {
				// insert data between prev and next
				break;
			}
			prev = next;
			next = next.getNext();
		}
		Node<E> dataNode = new Node<>(data, next);
		if (prev == null) {
			head = dataNode;
		} else {
			prev.setNext(dataNode);
		}
	}

	/**
	 * Remove the object with highest priority (at the front of the queue) from
	 * the priority queue.
	 * 
	 * @return data
	 */

	public E dequeue() {
		Node<E> top = head;
		if (head == null) {
			return null;
		}
		head = head.getNext();
		return top.getData();
	}

}
