import PAT.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Script {

    public static void main(String[] args) {
        GraphByTable graph = new GraphByTable(10);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 5);
        graph.insertEdge(2, 4);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(3, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 9);
        graph.insertEdge(5, 6);
        graph.insertEdge(5, 8);
        graph.insertEdge(5, 9);
        graph.insertEdge(6, 7);
        graph.insertEdge(6, 8);
        graph.insertEdge(8, 9);
        graph.print();
    }
}
