/*
Author: Mehir Wolde
Date generated: 07-10-2020
Date edited: 07-10-2020
README: Test program which allows the user to use depth first search to find a path between 2 chosen states in a directed graph. Creates a symbolgraph using 
the database file which creates a graph to send into the depthfirstsearch method.
*/

package labb4;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class testDi {
    public static void main(String[] args) throws FileNotFoundException {
        SymbolDiGraph t = new SymbolDiGraph("C:\\Users\\emilia\\Documents\\java\\labb4\\database.txt");     //skapa symbolgraf

        Scanner in = new Scanner(System.in);
        System.out.println("Travel from: ");
        String from = in.nextLine().toUpperCase();      //hämta vart man ska åka från
        int start = t.index(from);       
        System.out.println("To: ");
        String to = in.nextLine().toUpperCase();        //läsa in vart man ska åka till
        int end = t.index(to);

        DepthFirstDiPaths d = new DepthFirstDiPaths(t.G(), start);

        if(!d.hasPathTo(end))                             //om det inte existerar en väg mellan stationer
        {
            System.out.println("There is no path between the chosen states");
        }
        else                                            //annars printa ut den själv
        {
            for(int o : d.pathTo(end))
            {
                if(o == end)
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


