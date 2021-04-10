/*
Author: Mehir Wolde
Date generated: 25-09-2020
Date edited: 26-09-2020
README: Binary search tree class taken from Princeton, enables user to create a binary search tree with put and get
methods to add or use items from the tree
*/

package labb4;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root; // root of BST

    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public Node(Key key, Value val, int N) {        //nod konstruktor
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
 
    public int size() {     //returnerar size på bst
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public boolean isEmpty() {      //kollar om trädet är tomt
        return size() == 0;
    }

    public Value get(Key key) {     //returnerar värdet på en vald key
        return get(root, key);
    }

    private Value get(Node x, Key key) { // Return value associated with key in the subtree rooted at x;
                                         // return null if key not present in subtree rooted at x.
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);

        if (cmp < 0)
            return get(x.left, key);

        else if (cmp > 0)
            return get(x.right, key);
            
        else
            return x.val;
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);

        else if (cmp > 0)
            x.right = put(x.right, key, val);

        else
            x.val = val;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean contains(Key key) {      //kollar om bst innehåller en vald key
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Key min() {              //returnerar minsta keyn
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {          //returnerar största keyn
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x;      //om den inte har en höger är x == max så returna
        else                 return max(x.right); //annars returna högra noden anropat med max
    } 

    public Iterable<Key> keys() {           //returnerar alla keys i trädet
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {         
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0)
            keys(x.left, queue, lo, hi);

        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);

        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }
}