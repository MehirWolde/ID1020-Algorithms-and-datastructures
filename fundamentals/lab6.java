/*
Author: Mehir Wolde
Date generated: 08-09-2020
Date generated: 09-09-202
Implements a queue which holds integers based on the previous labs which also sorts the list in ascending order 
Code reused from lab 3 and node code taken from princeton
*/

package algolabb1;

public class lab6 {
    private Node first;
    private int size;

    private class Node{
        Node next;
        Node prev;
        int item;
    }
    
    public lab6(){
        first = new Node();
        size = 0;
    }

    public void add(int k)  //metod för att lägga till på bestämd plats
    {
        Node ny = new Node();  
        ny.item = k;
        
        if(size == 0)
        {
            first.item = k;
            first.next = first;
            first.prev = first;
        }

        else if(ny.item < first.item)
        {
            first.prev.next = ny;
            ny.prev = first.prev;
            ny.next = first;
            first.prev = ny;
            first = ny;
        }

        else
        {
            Node temp = first;
            for(int i = 1; i <= size; i++)
            {
                if(ny.item >= temp.item)
                {
                    temp = temp.next;
                }
            }

            ny.next = temp;
            ny.prev = temp.prev;
            temp.prev.next = ny;
            temp.prev = ny;
        }
        size++;
        print();
    }

    public void dequeue() { // Remove item from the beginning of the list.
        if (size == 1) 
        {
			first.next = null;
			first.prev = null;
			System.out.println("queue is now empty, enqueue before dequeueing again");
			size = 0;
		}

        else if (size == 0) 
        {
			System.out.println("queue is empty, enqueue before dequeuing");
		}

        else 
        {
			first.prev.next = first.next;
			first.next.prev = first.prev;
			first = first.next;
			size--;
		}

		print();
	}

    public void print()
    {
        Node n = first;
        for(int i = 1; i <= size; i++)
        {
            if(i == size)
            {
                System.out.println("[" + n.item + "]");
                break;
            }
            System.out.print("[" + n.item + "] , ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        
        System.out.println("Test, adding random numbers to the list and dequeing everything + 1");
        lab6 q = new lab6();
        for (int i = 0; i < 10; i++)
        {
            q.add((int)(Math.random()*100)+1);
        }
        for(int i = 0; i <= 10; i++)
        {
            q.dequeue();
        }
    
    }

}