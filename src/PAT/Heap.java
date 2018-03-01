package PAT;

public class Heap {
    int size = 0;
    private int capacity = 1000;
    private int[] dataArr = new int[capacity];

    public void insert(int data) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        dataArr[size + 1] = data;
        size++;
        swim(size);
    }

    public int deleteMax() {
        int firstIndex = 1;
        int tmp = dataArr[firstIndex];
        dataArr[firstIndex] = dataArr[size];
        dataArr[size] = tmp;
        size--;
        sink(firstIndex);
        return tmp;
    }

    private void sink(int index) {
        while (2 * index <= size) {
            int child = 2 * index;
            if (child != size && (dataArr[child] < dataArr[child + 1])) {
                child++;
            }
            if (dataArr[index] > dataArr[child]) break;
            else {
                int tmp = dataArr[index];
                dataArr[index] = dataArr[child];
                dataArr[child] = tmp;
            }
            index = child;
        }
    }

    private void swim(int index) {
        while (index > 1) {
            if (dataArr[index] > dataArr[index / 2]) {
                int tmp = dataArr[index];
                dataArr[index] = dataArr[index / 2];
                dataArr[index / 2] = tmp;
            } else break;
            index /= 2;
        }
    }

    public void printHeap() {
        for (int i = 1; i < size; i++) {
            System.out.print(dataArr[i] + " ");
        }
        System.out.println();
    }
}
