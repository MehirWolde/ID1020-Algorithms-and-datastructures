/*
Author: Mehir Wolde
Date generated: 07-09-2020
Date edited: 09-09-202
Implements a generic queue which allows you to remove an element from 
a place of your choosing
Iterator and node class taken from princeton
*/




package algolabb1;

import java.util.Iterator;

public class lab5<Item> implements Iterable<Item>{
	private Node first; // link to least recently added node
	private int n; // number of items on the queue

	private class Node { // nested class to define nodes
		Item item;
		Node next;
		Node prev;
	}

	public lab5() {
		first = new Node();
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) { // Add item to the end of the list.
		if(n == 0)
		{
			first.prev = first;
			first.next = first;
			first.item = item;
		}
		
		else
		{
			Node k = new Node();
			k.item = item;
			k.next = first;
			k.prev = first.prev;
			first.prev.next = k;
			first.prev = k;
		}
		n++;
		print();
	}

	public void removeAt(int f) { // Remove item from the beginning of the list.
        if(f > n || f <= 0)
        {
			System.out.println("enter a valid location between 1 & " + n);
		}
		
		else if(n == 0)
		{
			System.out.println("Queue is empty, enqueue before k again");
		}
		
		else if(f == n)
		{
			first.prev.next = first.next;
			first.next.prev = first.prev;
			first = first.next;
		}
		
        else
        {
            Node p = first.prev;
            for(int i = 1; i < f; i++)
            {
                p = p.prev;
            }
            
            p.next.prev = p.prev;
			p.prev.next = p.next;
			p.next = null;
			p.prev = null;
            n--;    
            print();
		}
	}

	public void print() 
	{
		Iterator<Item> s = this.iterator();
		int k = 0;
		while (k < n) 
		{
			Item item = s.next();
			if (k == (n - 1)) 
			{
				System.out.println("[" + item + "] ");
			} 
			else 
			{
				System.out.print("[" + item + "] , ");
			}
			k++;
		}
		
	}

	public Iterator<Item> iterator(){
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
    }

    public static void main(String[] args)
    {
		System.out.println("Testar för att lägga in och ta bort mer än antal platser");
        lab5<String> q = new lab5<String>();
        q.enqueue("item");
        q.enqueue("f");
		q.enqueue("hkl");
		q.removeAt(3);
		q.enqueue("labb");
		q.enqueue("ro");
		q.removeAt(2);  
		q.removeAt(1);  
		q.removeAt(1);
		q.removeAt(1);
		q.removeAt(1);
    
    }

}