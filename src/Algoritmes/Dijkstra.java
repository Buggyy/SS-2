package Algoritmes;

import java.util.Stack;
import sas.po2.lib.DirectedEdge;
import sas.po2.lib.EdgeWeightedDigraph;
import sas.po2.lib.IndexMinPQ;

/**
 *
 * @author ericravestein
 * @author Ömer Zülaloğlu [IS204] 500712124
 * @author Rafael Lobato [IS204] 500707274
 */
public class Dijkstra {

    private double[] distTo;          // distTo[v] = distance  of shortest s->v path
    private DirectedEdge[] edgeTo;    // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq;    // priority queue of vertices
    private int N;                    // Length of the path
    private int O;                    // Amount of vertices

    /**
     * Computes a shortest paths tree from <tt>s</tt> to every other vertex in
     * the edge-weighted digraph <tt>G</tt>.
     *
     * @param G the edge-weighted digraph
     * @param s the source vertex
     * @throws IllegalArgumentException if an edge weight is negative
     * @throws IllegalArgumentException unless 0 &le; <tt>s</tt> &le; <tt>V</tt>
     * - 1
     */
    public Dijkstra(EdgeWeightedDigraph G, int s) {
        for (DirectedEdge e : G.edges()) {
            if (e.weight() < 0) {
                throw new IllegalArgumentException("edge " + e + " has negative weight");
            }
        }

        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
                //  Increment amount of verices
                O++;
            }
            
        }

        // check optimality conditions
        assert check(G, s);
    }

    // relax edge e and update pq if changed
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    /**
     * Returns the length of a shortest path from the source vertex <tt>s</tt>
     * to vertex <tt>v</tt>.
     *
     * @param v the destination vertex
     * @return the length of a shortest path from the source vertex <tt>s</tt>
     * to vertex <tt>v</tt>;
     * <tt>Double.POSITIVE_INFINITY</tt> if no such path
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * Is there a path from the source vertex <tt>s</tt> to vertex <tt>v</tt>?
     *
     * @param v the destination vertex
     * @return <tt>true</tt> if there is a path from the source vertex
     * <tt>s</tt> to vertex <tt>v</tt>, and <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * Returns a shortest path from the source vertex <tt>s</tt> to vertex
     * <tt>v</tt>.
     *
     * @param v the destination vertex
     * @return a shortest path from the source vertex <tt>s</tt> to vertex
     * <tt>v</tt>
     * as an iterable of edges, and <tt>null</tt> if no such path
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
            //  Increment the length of the path
            N++;
        }
        return path;
    }

    public int getLength() {
        return N;
    }

    public int onderzochteKnopen() {
        return O;
    }

    // check optimality conditions:
    // (i) for all edges e:            distTo[e.to()] <= distTo[e.from()] + e.weight()
    // (ii) for all edge e on the SPT: distTo[e.to()] == distTo[e.from()] + e.weight()
    private boolean check(EdgeWeightedDigraph G, int s) {

        // check that edge weights are nonnegative
        for (DirectedEdge e : G.edges()) {
            if (e.weight() < 0) {
                System.err.println("negative edge weight detected");
                return false;
            }
        }

        // check that distTo[v] and edgeTo[v] are consistent
        if (distTo[s] != 0.0 || edgeTo[s] != null) {
            System.err.println("distTo[s] and edgeTo[s] inconsistent");
            return false;
        }
        for (int v = 0; v < G.V(); v++) {
            if (v == s) {
                continue;
            }
            if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
                System.err.println("distTo[] and edgeTo[] inconsistent");
                return false;
            }
        }

        // check that all edges e = v->w satisfy distTo[w] <= distTo[v] + e.weight()
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (distTo[v] + e.weight() < distTo[w]) {
                    System.err.println("edge " + e + " not relaxed");
                    return false;
                }
            }
        }

        // check that all edges e = v->w on SPT satisfy distTo[w] == distTo[v] + e.weight()
        for (int w = 0; w < G.V(); w++) {
            if (edgeTo[w] == null) {
                continue;
            }
            DirectedEdge e = edgeTo[w];
            int v = e.from();
            if (w != e.to()) {
                return false;
            }
            if (distTo[v] + e.weight() != distTo[w]) {
                System.err.println("edge " + e + " on shortest path not tight");
                return false;
            }
        }
        return true;
    }
}


        /**
         * File folder = new File(""); File[] listOfFiles = folder.listFiles();
         *
         * if (args.length == 0) { String fileName = listOfFiles[0].toString();
         * TileWorld tw = new TileWorld(fileName); tw.show(fileName, 20, 0, 0);
         *
         * int endIndex = tw.findEndIndex(); int startIndex =
         * tw.findStartIndex();
         *
         *
         * }
         *
         */
