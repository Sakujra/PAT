package PAT;

public class UnionFindSet {

    public int getParts() {
        return parts;
    }

    private int parts = 0;
    private int size = 0;
    private int[] arr;

    public UnionFindSet(int size) {
        this.size = size;
        this.parts = size;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    public int find(int x) {
        if (arr[x] < 0) return x;
        else return arr[x] = find(arr[x]);
    }

    public void union(int root1, int root2) {
        if (root1 == root2) return;
        if (arr[root1] < arr[root2]) {
            arr[root1] += arr[root2];
            arr[root2] = root1;
        } else {
            arr[root2] += arr[root1];
            arr[root1] = root2;
        }
        parts--;
    }

    public int getMaxSizeOfParts() {
        int negativeMax = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < negativeMax) negativeMax = arr[i];
        }
        return -negativeMax;
    }

}
