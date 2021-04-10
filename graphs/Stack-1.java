/*
Author: Mehir Wolde
Date generated: 05-10-2020
Date edited: 05-10-2020
README: Iterable stack class taken from lab 1 and modified to not be double linked and circular. Only supports push and pop function which adds 
item to the beginning of the queue or removes
Code is used in both BST,DepthFirstPaths and BreadthFirstPaths class
*/
package labb4;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first; // referens till den första noden i stacken
    private Node last;
	private int n; // antal noder i stacken

	private class Node { // nested class to define nodes
		Item item;		//vad som ligger i noden
		Node next;		//nodpekare till nästa nod
	}

	public Stack() {		//konstruktor som används när man skapar en stack
		first = null;		//skapar första noden till kön utan att tilldela något item
		n = 0;		//sätter storleken
	}

	public boolean isEmpty() {		//kollar om stacken är tom
		return first == null;
	}

	public int size() {		//returnerar storlek av stacken
		return n;
	}

	public void push(Item item) { // lägger till en ny nod i början/toppen av stacken
		Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) first = last;
        n++;
    }
    
    public Item pop() {			//tar bort första noden på stacken
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
	public Iterator<Item> iterator() 	//iterator konstruktor
	{
		return new listIterator();
	}

	private class listIterator implements Iterator<Item> 		//iterator klass
	{
		private Node current = first;		//startar på första
		private int count = 0;

		public boolean hasNext() {			//kollar om iterator har ett element efter
			return count < n;
		}

		public Item next() 					//returnerar nuvarande och sätter att peka på dens nästa
		{
			Item item = current.item;
			current = current.next;
			count++;
			return item;
		}
    }
}

