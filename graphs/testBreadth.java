/*
Author: Mehir Wolde
Date generated: 06-10-2020
Date edited: 07-10-2020
README: Test program which allows the user to use breadth first search to find a path between 2 chosen states in a undirected graph. Creates a symbolgraph using 
the database file which creates a graph to send into the breadthfirstsearch method.
*/

package labb4;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class testBreadth {
    public static void main(String[] args) throws FileNotFoundException {
        SymbolGraph t = new SymbolGraph("C:\\Users\\emilia\\Documents\\java\\labb4\\database.txt");     //skapa symbolgraf
        Scanner in = new Scanner(System.in);
        System.out.println("Travel from: ");
        String from = in.nextLine().toUpperCase();      //läsa in vart man ska åka från
        int s = t.index(from);
        System.out.println("To: ");
        String to = in.nextLine().toUpperCase();        //läsa in vart man ska åka till
        int v = t.index(to);
        Graph G = t.G();                                //hämta graf från symbolgraf
        BreadthFirstPaths b = new BreadthFirstPaths(G, s);
        if(!b.hasPathTo(v))                             //om det inte existerar en väg mellan stationer
        {
            System.out.println("There is no path between the chosen states");
        }
        else                                            //annars printa ut den själv
        {
            for(int o : b.pathTo(v))
            {
                if(o == v)
                {
                    System.out.print(t.name(o));
                }
                else
                {
                    System.out.print(t.name(o) + "--> ");
                }
            }
        }
    }
}

