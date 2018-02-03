package PAT;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class $1002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Node> arr1 = getInputArray(scanner.nextLine());
        ArrayList<Node> arr2 = getInputArray(scanner.nextLine());
        ArrayList<Node> c = sum(arr1, arr2);
        System.out.print(c.size() + " ");
        for (int i = 0; i < c.size(); i++) {
            System.out.print(c.get(i).exp + " " + c.get(i).coe + " ");
        }
    }

    public static ArrayList<Node> getInputArray(String str) {
        String[] arrStr = str.split(" ");
        int length = Integer.parseInt(arrStr[0]);
        ArrayList<Node> nodes = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Node node = new Node();
            node.exp = Integer.parseInt(arrStr[2 * i + 1]);
            node.coe = Float.parseFloat(arrStr[2 * i + 2]);
            nodes.add(node);
        }
        return nodes;
    }

    public static ArrayList<Node> sum(ArrayList<Node> a, ArrayList<Node> b) {
        int i = 0;
        int j = 0;
        ArrayList<Node> c = new ArrayList<>(a.size());
        while (i < a.size() && j < b.size()) {
            Node node = new Node();
            if (a.get(i).exp == b.get(j).exp) {
                node.exp = a.get(i).exp;
                node.coe = a.get(i).coe + b.get(j).coe;
                i++;
                j++;
            } else if (a.get(i).exp > b.get(j).exp) {
                node.exp = a.get(i).exp;
                node.coe = a.get(i).coe;
                i++;
            } else {
                node.exp = b.get(j).exp;
                node.coe = b.get(j).coe;
                j++;
            }
            c.add(node);
        }
        for (; i < a.size(); i++) {
            Node node = new Node();
            node.exp = a.get(i).exp;
            node.coe = a.get(i).coe;
            c.add(node);
        }
        for (; j < b.size(); j++) {
            Node node = new Node();
            node.exp = b.get(j).exp;
            node.coe = b.get(j).coe;
            c.add(node);
        }
        return c;
    }
}

class Node {
    float coe;
    int exp;
}
