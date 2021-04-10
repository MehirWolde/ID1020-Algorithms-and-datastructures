/*
Author: Mehir Wolde
Date generated: 03-05-2020
Date edited: 05-10-2020
README: A program which reads in a text file to create an undirected graph and a symboltable(Binary search tree) based on that graph with
states as keys and an index as their value. 
Code inspired by the book Algortihm's 4th ed
*/


package labb4;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class SymbolGraph {
    private BST<String, Integer> st; // String -> index
    private String[] keys; // index -> String
    private Graph G; // grafen

    public SymbolGraph(String stream)throws FileNotFoundException {
        st = new BST<String, Integer>();
        Scanner in = new Scanner(new FileReader(stream)); //läser in text
        while (in.hasNextLine()) //läser rad för rad
        {
            String[] a = in.nextLine().split(" "); //skapar array med varje enskild sträng som separeras med ett mellanslag
            for (int i = 0; i < a.length; i++) //loopa igenom array
                if (!st.contains(a[i])) 
                    st.put(a[i], st.size()); //tilldela distinkt sträng ett specifikt värde
        }

        keys = new String[st.size()]; //skapa array för att hämta nyckel från ett värde
        for (String name : st.keys()) 
            keys[st.get(name)] = name; // lägger alla keys i arrayen 

        G = new Graph(st.size()); //initiera graf graf
        in = new Scanner(new FileReader(stream)); // läser in filen igen
        while (in.hasNextLine()) //skapar kanter mellan hörn i grafen
        { 
            String[] a = in.nextLine().split(" "); 
            G.addEdge(st.get(a[0]), st.get(a[1]));  
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

    public Graph G() {                      //returnerar symbolgrafens graf
        return G;
    }
}
