/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.pkg2;

import Algoritmes.Dijkstra;
import Algoritmes.FloydWarshall;
import nl.hva.dmci.ict.inf.ads.lib.Stopwatch;
import sas.po2.lib.AdjMatrixEdgeWeightedDigraph;
import sas.po2.lib.DirectedEdge;
import sas.po2.lib.EdgeWeightedDigraph;

/**
 *
 * @author Ömer Zülaloğlu [IS204] 500712124
 * @author Stefan Lobato [IS204] 500707274
 */
public class SS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //  LOOP THROUGH ALL TILEWORLDS
        //  Dijkstra
        System.out.println("-------------     DIJKSTRA     -------------");
        //  21 + 3 custom tiles
        for (int i = 1; i <= 24; i++) {
            EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i" + i);

            //  Compute shortest paths tree with EdgeWeightedDigraph
            Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());

            Iterable<DirectedEdge> edges = null;

            if (d.hasPathTo(edgeGraph.getEnd())) {
                Stopwatch s = new Stopwatch();

                //  Shortest path from the source vertex
                edges = d.pathTo(edgeGraph.getEnd());

                System.out.printf("i%d\tTijd: %.3f\tKnopen: %d\tLengte: %d\tKosten: %.1f\n",
                        i,
                        //  Time taken
                        s.elapsedTime(),
                        //  Amount of vertices looked into
                        d.onderzochteKnopen(),
                        //  Length of the path
                        d.getLength(),
                        //  Costs of the path
                        d.distTo(edgeGraph.getEnd())
                );
                //  Draw path on bitmap
                edgeGraph.tekenPad(edges);
            } else {
                System.out.printf("i%d\tCannot draw path, endpoint unreachable\n",
                        i
                );
            }
            // Show the bitmap with drawn path
//            edgeGraph.show("i" + i, "i" + i);
        }

        //  Create space between output
        System.out.println("\n");

        //  LOOP THROUGH ALL TILEWORLDS
        //  Floyd
        System.out.println("-------------     FLOYD WARSHALL     -------------");
        //  21 + 3 custom tiles
        for (int i = 1; i <= 24; i++) {
            EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i" + i);

            AdjMatrixEdgeWeightedDigraph G = edgeGraph.createAdjMatrixEdgeWeightedDigraph();

            //  Compute shortest paths tree with an edge-weighted digraph
            FloydWarshall f = new FloydWarshall(G);

            Iterable<DirectedEdge> edges = null;

            if (f.hasPath(edgeGraph.getStart(), edgeGraph.getEnd())) {
                Stopwatch s = new Stopwatch();
                
                //  Shortest path from the source vertex
                edges = f.path(edgeGraph.getStart(), edgeGraph.getEnd());

                System.out.printf("i%d\tTijd: %.3f\tKnopen: %d\tLengte: %d\tKosten: %.1f\n",
                        i,
                        //  Time taken
                        s.elapsedTime(),
                        //  Amount of vertices looked into
                        f.onderzochteKnopen(),
                        //  Length of the path
                        f.getLength(),
                        //  Costs of the path
                        f.dist(edgeGraph.getStart(), edgeGraph.getEnd())
                );
                //  Draw path on bitmap
                edgeGraph.tekenPad(edges);
            } else {
                System.out.printf("i%d\tCannot draw path, endpoint unreachable\n",
                        i
                );
            }
            // Show the bitmap with drawn path
//            edgeGraph.show("i" + i, "i" + i);

        }

        //  JUST TEST 1 TILEWORLD
        //  Dijkstra
//        System.out.println("-------------   DIJKSTRA (One Tile)  -------------");
//        EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i14");
//
//        Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());
//
//        Iterable<DirectedEdge> edges = null;
//
//        if (d.hasPathTo(edgeGraph.getEnd())) {
//
//            edges = d.pathTo(edgeGraph.getEnd());
//
//            System.out.printf("Knopen: %d, Lengte: %d, Kosten: %.1f \n",
//                    d.onderzochteKnopen(),
//                    d.getLength(),
//                    d.distTo(edgeGraph.getEnd())
//            );
//
//            edgeGraph.tekenPad(edges);
//        }
//        //  Show the tile
//        edgeGraph.show("i10", "i10");
        //  JUST TEST 1 TILEWORLD
        //  Dijkstra
    }

}
