/*
Author: Mehir Wolde
Date generated: 06-10-2020
Date edited: 07-10-2020
README: A program based on DFS, in a directed graph, which can answer questions of the type:
"Find the a path from X to Y" Which should result in a list of vertices traversed from X to Y if there is a path.
*/

package labb4;

public class DepthFirstDiPaths {
    private boolean[] marked; //Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public DepthFirstDiPaths(DiGraph G, int s) {        //constructor to initiate an object of type depthfirstpaths
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(DiGraph G, int v) {            
        marked[v] = true;                           //mark source/vertex
        for (int w : G.adj(v))                      
            if (!marked[w]) {                       //if vertex is not marked go to next
                edgeTo[w] = v;                      //exists edge with previous source
                dfs(G, w);                          //recursive function call
            }
    }

    public boolean hasPathTo(int v) {               //if there exists a path from source to v
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {        //returns a stack with the path to v from source
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
