package PAT;

public class GraphByTable {

    private class GNode {

        public GNode(int index) {
            adjcentNode = index;
        }

        int adjcentNode = -1;
        GNode next = null;
    }

    GNode[] nodes;

    public GraphByTable(int size) {
        nodes = new GNode[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new GNode(i);
        }
    }

    public void insertEdge(int node1, int node2) {
        GNode lastNode = nodes[node1];
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new GNode(node2);

        lastNode = nodes[node2];
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new GNode(node1);
    }


    public void print() {
        for (int i = 0; i < nodes.length; i++) {
            GNode node = nodes[i];
            while (node != null) {
                System.out.print(node.adjcentNode + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
