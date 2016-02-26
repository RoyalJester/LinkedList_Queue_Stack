/*
* Author: Jesus Gonzalez
*
*/

package data_structures;

import java.util.Iterator;

public class Queue<E> implements Iterable<E>{
	
	private ListADT<E> queuelist;
	
	public Queue() {
		queuelist = new LinkedListDS<E>();
	}

	// inserts the object obj into the queue
	public void enqueue(E obj) {
		queuelist.addLast(obj);
	}

	// removes and returns the object at the front of the queue   
	public E dequeue() {
		return queuelist.removeFirst();
	}

	// returns the number of objects currently in the queue    
	public int size() {
		return queuelist.size();
	}

	// returns true if the queue is empty, otherwise false   
	public boolean isEmpty() {
		return queuelist.isEmpty();
	}

	// returns but does not remove the object at the front of the queue   
	public E peek() {
		return queuelist.peekFirst();
	}

	// returns true if the Object obj is in the queue    
	public boolean contains(E obj) {
		return queuelist.contains(obj);
	}

	// returns the queue to an empty state  
	public void makeEmpty() {
		queuelist.makeEmpty();
	}

	// removes the Object obj if it is in the queue and
	// returns true, otherwise returns false.
	public boolean remove(E obj) {
		return queuelist.remove(obj);
	}

	// returns an iterator of the elements in the queue.  The elements
	// must be in the same sequence as dequeue would return them.    
	public Iterator<E> iterator() {
		return queuelist.iterator();
	}
}