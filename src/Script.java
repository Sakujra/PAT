import PAT.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Script {

    public static void main(String[] args) {
        Dijkstra_Table graph  = new Dijkstra_Table(7);
        graph.insertEdge(1,2,2);
        graph.insertEdge(1,4,1);
        graph.insertEdge(2,4,3);
        graph.insertEdge(2,5,10);
        graph.insertEdge(3,1,4);
        graph.insertEdge(3,6,5);
        graph.insertEdge(4,3,2);
        graph.insertEdge(4,5,2);
        graph.insertEdge(4,6,8);
        graph.insertEdge(4,7,4);
        graph.insertEdge(5,7,6);
        graph.insertEdge(7,6,1);
        graph.print();

        graph.dijkstra(0);
    }
}
