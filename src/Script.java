import PAT.AVLTree;
import PAT.BinarySearchTree;
import PAT.Heap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Script {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(46);
        heap.insert(23);
        heap.insert(26);
        heap.insert(24);
        heap.insert(10);
        heap.deleteMax();
        int a = 1;
    }
}
