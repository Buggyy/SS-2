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

        //LOOP THROUGH ALL TILEWORLDS
//        for (int i = 1; i <= 25; i++) {
//            EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i" + i);
//
//            Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());
//            System.out.println(edgeGraph.V());
//            Iterable<DirectedEdge> edges = null;
//
//            if (d.hasPathTo(edgeGraph.getEnd())) {
//                Stopwatch s = new Stopwatch();
//                edges = d.pathTo(edgeGraph.getEnd());
//                System.out.printf("i%d: %.3f, weight cost: %.1f, knooppunten: "
//                        + "%d\n", i, s.elapsedTime(), 
//                        d.distTo(edgeGraph.getEnd()),
//                        d.onderzochteKnopen());
//                edgeGraph.tekenPad(edges);
//            }
//
//        }
        //JUST TEST 1 TILEWORLD
        EdgeWeightedDigraph edgeGraph = new EdgeWeightedDigraph("i24");
        
        Dijkstra d = new Dijkstra(edgeGraph, edgeGraph.getStart());
        
        System.out.println(d.hasPathTo(edgeGraph.getEnd()));
        
        Iterable<DirectedEdge> edges = null;
        if (!d.hasPathTo(edgeGraph.getEnd())) {
            edges = d.pathTo(edgeGraph.getEnd());
            edgeGraph.tekenPad(edges);
        }
        edgeGraph.show("i24", "i24");

    }

}
