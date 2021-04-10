/*
Author: Mehir Wolde
Date generated: 05-09-2020
Date edited: 9-9-2020
queue class and Iterator class taken from Algorithm 4ed
This code creates a generic type and iterable FIFO queue by implementing a circular doubly linked list
which can add an item to the end of the lab3 and remove an item from the front of the lab3
*/

package algolabb1;

import java.util.Iterator;

public class lab3<Item> implements Iterable<Item> {
	private Node first; // referens till den första noden i listan
	private int n; // antal noder i listan

	private class Node { // nested class to define nodes
		Item item;		//vad som ligger i noden
		Node next;		//nodpekare till nästa nod
		Node prev;		//nodpekare till föregående nod
	}

	public lab3() {		//konstruktor som används när man skapar en queue
		first = new Node();		//skapar första noden till kön utan att tilldela något item
		n = 0;		//sätter storleken
	}

	public boolean isEmpty() {		//kollar om listan är tom
		return first == null;
	}

	public int size() {		//returnerar storlek av listan
		return n;
	}

	public void enqueue(Item item) { // lägger till en ny nod med ett nytt item till slutet av kön
		if(n == 0)		//om kön är tom behöver vi bara tilldela first argument värdet
		{
			first.prev = first;		//first ska peka på sig själv
			first.next = first;
			first.item = item;
		}
		
		else		//annars ska vi lägga till en ny nod i listan
		{
			Node k = new Node();		//skapar en nod 
			k.item = item;				//tilldelar argumentvärde till nod
			k.next = first;
			k.prev = first.prev;		//lägger att nya sistas föregående är gamla sista
			first.prev.next = k;		//sätter att nya sista nästa är första
			first.prev = k;				//sätter att första ska peka bak till nya
		}
		n++;							//öka storlek på listan
		stringPrint();
	}

	public void dequeue() { // FIFO så vår dequeue tar bort första element
		if (n == 1) 
		{
			first.next = null;			//sätter att den inte ska peka på något
			first.prev = null;
			System.out.println("queue is now empty, enqueue before dequeuing again");
			n = 0;
		}

		else if (n == 0) {			//hantera ifall man dequque en tom lista
			System.out.println("queue is empty, enqueue before dequeuing");
		}

		else 
		{
			System.out.println("the removed item was [" + first.item + "]");
			first.prev.next = first.next;		//sista nod ska peka på förstas nästa
			first.next.prev = first.prev;		//förstas nästa ska peka bak mot sista
			first = first.next;					//först pekare ska peka på första nästa
			n--;								//minska storlek på lista
		}

		stringPrint();
	}


	public void stringPrint()		//toString metod som använder en for each loop som appendar items till en stringbuilder
	{
		StringBuilder s = new StringBuilder();
		int f = 1;
		for(Item item : this)
		{
			if(f == n)
			{
				s.append("[" + item + "]");
				break;
			}
			s.append("[" + item + "] , ");
			f++;
		}

		System.out.println(s);

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


	public static void main(String[] args) {
		lab3<String> lab3 = new lab3<String>();
		
		System.out.println("Test 1: testing if enqueue and dequeue works");
		lab3.enqueue("f");
		lab3.enqueue("b");
		lab3.enqueue("x");
		lab3.enqueue("3");
		lab3.dequeue();
		lab3.dequeue();
		lab3.dequeue();
		lab3.dequeue();
		lab3.dequeue();
		lab3.enqueue("5");
		lab3.enqueue("hfjk");
		System.out.println();

		lab3<String> l = new lab3<String>();
		System.out.println("Test 2: dequeueing more items than size of the queue");
		l.enqueue("fh");
		l.enqueue("jbk");
		l.enqueue("k");
		l.dequeue();
		l.dequeue();
		l.dequeue();
		l.dequeue();
		l.dequeue();

	}
}