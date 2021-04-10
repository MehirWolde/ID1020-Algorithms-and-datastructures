/*
Author: Mehir Wolde
Date generated: 03-05-2020
Date edited: 05-10-2020
README: A program which reads in a text file to create a directed graph and a symboltable(Binary search tree) based on that graph with
states as keys and an index as their value. 
Code inspired by the book Algortihm's 4th ed
*/


package labb4;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class SymbolDiGraph {
    private BST<String, Integer> st; // String -> index
    private String[] keys; // index -> String
    private DiGraph G; // the graph

    public SymbolDiGraph(String stream)throws FileNotFoundException {
        st = new BST<String, Integer>();
        Scanner in = new Scanner(new FileReader(stream)); // First pass
        while (in.hasNextLine()) // builds the index
        {
            String[] a = in.nextLine().split(" "); // by reading strings
            for (int i = 0; i < a.length; i++) // to associate each
                if (!st.contains(a[i])) // distinct string
                    st.put(a[i], st.size()); // with an index.
        }

        keys = new String[st.size()]; // Inverted index
        for (String name : st.keys()) // to get string keys
            keys[st.get(name)] = name; // is an array.

        G = new DiGraph(st.size());
        in = new Scanner(new FileReader(stream)); // Second pass
        while (in.hasNextLine()) // builds the graph
        {
            String[] a = in.nextLine().split(" "); // by connecting the
            G.addEdge(st.get(a[0]), st.get(a[1])); // to all the others.
        }
    }

    public boolean contains(String s) {     //kollar om hörn/station finns i symbolgraph
        return st.contains(s);
    }

    public int index(String s) {           //hämtar motsvarande index för s(station)
        return st.get(s);
    }

    public String name(int v) {            //hämtar motsvarande string for i
        return keys[v];
    }

    public DiGraph G() {                      //returnerar symbolgrafens graf
        return G;
    }
}
