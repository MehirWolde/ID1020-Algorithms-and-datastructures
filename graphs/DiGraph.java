/*
Author: Mehir Wolde
Date generated: 03-10-2020
Date edited: 07-10-2020
README: Graph class which allows the user to create a directed graph with chosen amount of vertices. Stores
adjacent vertices in a bag array
Code inspired by the book Algorithms 4th ed
*/

package labb4;

public class DiGraph {
    private final int V; // number of vertices
    private int E; // number of edges
    private Bag<Integer>[] adj; // adjacency lists

    public DiGraph(int V) {       //skapar en ny graf med V hörn
        this.V = V; //sätt antal hörn och antal kanter
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; //skapa tom adjecency lista
        for (int v = 0; v < V; v++) // initierar alla listor som tomma
            adj[v] = new Bag<Integer>(); 
    }

    public int V() {        //hämtar antal hörn
        return V;
    }

    public int E() {        //hämtar antal kanter
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); //Skapa en riktad kant från v till w
        E++;
    }

    public Iterable<Integer> adj(int v) {   //returnear en vektor med alla hörn som har kant med v
        return adj[v];
    }
}
    