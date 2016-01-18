/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.pkg2;

import Algoritmes.Dijkstra;
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
//        for (int i = 22; i <= 24; i++) {
//            EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i" + i);
//            
//            Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());
//
//            Iterable<DirectedEdge> edges = null;
//
//            if (d.hasPathTo(edgeGraph.getEnd())) {
//                Stopwatch s = new Stopwatch();
//                edges = d.pathTo(edgeGraph.getEnd());
//                
//                System.out.printf("i%d: Knopen: %d, Lengte: %.1f, Kosten: \n"
//                        ,i,
//                        d.onderzochteKnopen(),                    
//                        d.distTo(edgeGraph.getEnd()));
//                
//                edgeGraph.tekenPad(edges);
//            }
//            // Show the tiles
//            edgeGraph.show("i" + i, "i" + i);
//        }

        //  LOOP THROUGH ALL TILEWORLDS
        //  Floyd
//        for (int i = 1; i <= 21; i++) {
//            EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i" + i);
//
//            // random graph with V vertices and E edges, parallel edges allowed
//            int V = edgeGraph.V();
//              createAdjMatrixEdgeWeightedDigraph
//            AdjMatrixEdgeWeightedDigraph G = new AdjMatrixEdgeWeightedDigraph(V);
// 
//            FloydWarshall f = new FloydWarshall(G);
//
//            System.out.println(f);
//            Iterable<DirectedEdge> edges = null;
//
//            System.out.println("start" + edgeGraph.getStart());
//            
//            System.out.println("e" + edgeGraph.getEnd());
//            
//            if (f.hasPath(edgeGraph.getStart(), edgeGraph.getEnd())) {
//                Stopwatch s = new Stopwatch();
//                
//                edges = f.path(edgeGraph.getStart(), edgeGraph.getEnd());
//                
//                System.out.printf("i%d: %.3f, weight cost: %.1f, knooppunten: "
//                        + "%d\n", i, s.elapsedTime(),
//                        f.dist(edgeGraph.getStart(), edgeGraph.getEnd()),
//                        G.V());
//                edgeGraph.tekenPad(edges);
//            }
//
//        }
//        File folder = new File("");
//        File[] listOfFiles = folder.listFiles();
//        
//        if (args.length == 0) {
//            String fileName = listOfFiles[0].toString();
//            TileWorld tw = new TileWorld(fileName);
//            tw.show(fileName, 20, 0, 0);
//            
//            int endIndex = tw.findEndIndex();
//            int startIndex = tw.findStartIndex();
//            
//            
//        }
        
        //JUST TEST 1 TILEWORLD
        //  i20, i10
       EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i1");
       
            Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());

            Iterable<DirectedEdge> edges = null;

            if (d.hasPathTo(edgeGraph.getEnd())) {
       
                edges = d.pathTo(edgeGraph.getEnd());
                
                System.out.printf("Knopen: %.1f, Lengte: %d, Kosten: \n"
                        ,d.distTo(edgeGraph.getEnd()),                    
                        d.onderzochteKnopen());
                //  Only costs needed
                
                edgeGraph.tekenPad(edges);
            }
            // Show the tiles
            edgeGraph.show("i1", "i1");
    }

      
}
