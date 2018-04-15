/* Assignment: 
 * Author: Jennifer N. Smith
 * Date:
 * Reference: 
 */
/**
 * Models a node in the link list
 * 
 * @author Jennifer Smith
 *
 * @param <E>
 *            type of item in the linked list
 */
public class Node<E> implements INode<E> {

	private E dataValue;
	private Node nextNode;

	/**
	 * Construct an instance
	 * 
	 * @param dataValue
	 *            data value
	 */

	Node(E dataValue) {
		this.dataValue = dataValue;
		this.nextNode = null;

	}

	/**
	 * Construct a node
	 * 
	 * @param dataValue
	 *            data value
	 * @param nextNode
	 *            next node
	 */

	Node(E dataValue, Node<E> nextNode) {
		this.dataValue = dataValue;
		this.nextNode = nextNode;
	}

	@Override

	/**
	 * Returns the data stored in this node.
	 * 
	 * @return data
	 */

	public E getData() {
		return dataValue;
	}

	/**
	 * Returns the node next to this node.
	 * @return the node next to this node
	 * 
	 */
	
	@Override
	public Node<E> getNext() {
		return nextNode;
	}

	/**
	 *  Sets node received as the next node to this node.
	 */
	
	@Override
	public void setNext(Node<E> next) {
		this.nextNode = next;
	}

}
