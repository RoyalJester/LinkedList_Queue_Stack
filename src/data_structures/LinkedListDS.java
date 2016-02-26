/*
 * Author: Jesus Gonzalez
 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDS<E> implements ListADT<E> {

	private Node<E> head;
	int currentSize;

	public class Node<T> {
		T data;
		Node<T> next;

		Node(T obj) {
			data = obj;
			next = null;
		}
	}

	//Default Constructor for Linked List
	public LinkedListDS() {
		head = null;
		currentSize = 0;
	}

	//Adds the Object obj to the beginning of the list
	public void addFirst(E obj) {
		Node<E> newNode = new Node<E>(obj);
		
		if (head == null) {
			head = newNode;
			currentSize++;
		} 
		else {
			newNode.next = head;
			head = newNode;
			currentSize++;
		}
	}

	//Adds the Object obj to the end of the list
	public void addLast(E obj) {
		Node<E> current = head;
		Node<E> newNode = new Node<E>(obj);

		if(head == null) { // test so we can use current.next in the while loop
			head = newNode;
			currentSize++;
		}  
		else {
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			currentSize++;
		}
	}  

	//  Removes the first Object in the list and returns it.
	//  Returns null if the list is empty.
	public E removeFirst() {
		Node<E> temp;

		if (head != null) {
			temp = head;
			head = head.next;
			currentSize--;
			return temp.data;
		}
		else {
			return null;
		}
	}

	//  Removes the last Object in the list and returns it.
	//  Returns null if the list is empty.
	public E removeLast() {
		Node<E> current = head;
		Node<E> last = null;

		if (head == null) { //Empty List
			return null;
		}

		while(current.next != null) { //Traversing the list to get to the tail end
			last = current;
			current = current.next;
		}
		last.next = null;    //Reached the end. remove the tail and size-1. return data.
		currentSize--;
		return current.data;
	}

	//  Returns the first Object in the list, but does not remove it.
	//  Returns null if the list is empty.
	public E peekFirst() {
		if(head != null) {
			return head.data;
		}
		return null;
	}

	//  Returns the last Object in the list, but does not remove it.
	//  Returns null if the list is empty.
	public E peekLast() {
		Node<E> current = head;		

		if(head == null) {
			return null;
		}

		while(current.next != null) {
			current = current.next;
		}

		return current.data;
	}

	//  Finds and returns the Object obj if it is in the list, otherwise
	//  returns null.  Does not modify the list in any way
	@SuppressWarnings("unchecked")
	public E find(E obj) {
		Node<E> current = head;	

		if(head == null) {
			return null;
		}

		while(current != null && ((Comparable<E>) obj).compareTo(current.data) != 0) { //Traverse the list to find the object obj
			current = current.next;										
		}

		if(current != null && ((Comparable<E>) obj).compareTo(current.data) == 0) {
			return obj;
		}
		return null;
	}

	//  Removes the first instance of the specific Object obj from the list, if it exists.
	//  Returns true if the Object obj was found and removed, otherwise false
	@SuppressWarnings("unchecked")
	public boolean remove(E obj) {
		Node<E> current = head;
		Node<E> last = null;

		while(current != null && ((Comparable<E>)obj).compareTo(current.data) != 0) { //Keep traversing if obj not matching
			last = current;
			current = current.next;
		}

		if(current == null) { 	//The head is null
			return false;
		}

		if(current == head) {
			head = head.next;
		}

		else if(current.next == null) {
			last.next = null;
		}
		else {
			last.next = current.next;
		}
		currentSize--;
		return true;
	}

	//  The list is returned to an empty state.
	public void makeEmpty() {
		head = null;
		currentSize = 0;
	}

	//  Returns true if the list contains the Object obj, otherwise false
	@SuppressWarnings("unchecked")
	public boolean contains(E obj) {
		Node<E> current = head;

		while(current != null) {
			if(((Comparable<E>)obj).compareTo(current.data) == 0) { //Traverse to find matching objects.
				return true;									
			}
			current = current.next;
		}
		return false;
	}

	//  Returns true if the list is empty, otherwise false
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}

	//  Returns true if the list is full, otherwise false
	public boolean isFull() {
		return false;
	}

	//  Returns the number of Objects currently in the list.
	public int size() {
		return currentSize;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	//  Returns an Iterator of the values in the list, presented in
	//  the same order as the list.
	public Iterator<E> iterator() {
		return (Iterator<E>) new IteratorHelper();
	}

	//Begin iterator helper class
	class IteratorHelper implements Iterator<E> {

		Node<E> iterptr;

		public IteratorHelper() {
			iterptr = head;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E temp = iterptr.data;
			iterptr = iterptr.next;
			return temp;
		}

		public boolean hasNext() {
			return iterptr != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	} 
	//end of interator helper
	////////////////////////////////////////////////////////////////////////////////////////////
}