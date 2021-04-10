/*
Author: Mehir Wolde
Date generated: 25-09-2020
Date generated: 28-09-2020
README: Frequency counter class taken from prinston. Augmented to take in a file from the user and then by using Binary search and a Binary
search tree it stores a chosen amount of words from the text and then finds the amount of distinct words and finds the most frequent word
*/

package labb3;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class frequencyCounter {

    // Do not instantiate.
    private frequencyCounter() { }

    public static void main(String[] args) throws FileNotFoundException  {
        int distinct = 0, words = 0;        
        Scanner n = new Scanner(System.in);
        System.out.println("Enter amount of words");
        int size = n.nextInt();
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(size);     //
        Scanner ST = new Scanner(new FileReader("C:\\Users\\emilia\\Documents\\java\\labb3\\write.txt"));
        Scanner BST = new Scanner(new FileReader("C:\\Users\\emilia\\Documents\\java\\labb3\\write.txt"));
        // compute frequency counts
        long startTime1 = System.nanoTime();
        while (ST.hasNext() && words < size) {
            String key = ST.next().toLowerCase();
            if (key.length() < 1) 
                continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        long elapsedtime1 = System.nanoTime() - startTime1;
        System.out.println("Binary Search ST");
        System.out.println("Elapsed time: " + elapsedtime1 + "ns");
        System.out.println("The most frequent word is: [" + max + "] and it appears: " + st.get(max) + " times");
        System.out.println("amount of distinct words = " + distinct);
        System.out.println("amount of words = " + words);
        System.out.println();
        words = 0;
        distinct = 0;

        BST<String, Integer> bst = new BST<String, Integer>();
        startTime1 = System.nanoTime();
        while (BST.hasNext() && words < size) {
            String key2 = BST.next().toLowerCase();
            if (key2.length() < 1) 
                continue;
            words++;
            if (bst.contains(key2)) {
                bst.put(key2, bst.get(key2) + 1);
            }
            else {
                bst.put(key2, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max2 = "";
        bst.put(max2, 0);
        for (String word2 : bst.keys()) {
            if (bst.get(word2) > bst.get(max2))
                max2 = word2;
        }
        elapsedtime1 = System.nanoTime() - startTime1;
        System.out.println("BST");
        System.out.println("Elapsed time: " + elapsedtime1 + "ns");
        System.out.println("The most frequent word is: [" + max2 + "] and it appears: " + bst.get(max2) + " times");
        System.out.println("amount of distinct words = " + distinct);
        System.out.println("amount of words = " + words);

    }
}