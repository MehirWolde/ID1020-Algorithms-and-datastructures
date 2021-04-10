/*
Author: Mehir Wolde
Date generated: 03-10-2020
Date edited: 05-10-2020
README: Bag class taken from previous labs, allows the user to create a bag,store items in it and iterate through the bag
Used in graph class to store adjacent vertices
*/

package labb4;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first; // first node in list

    private class Node {        //privat nodeklass
        Item item;
        Node next;
    }

    public void add(Item item) { // lägg till item i bagen
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator() {      //iteratorkonstruktor
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {  //iteratorklass
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}