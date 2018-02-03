package array.easy;

public class $766ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] b = new int[][]{{1, 2}, {2, 2}};
        System.out.println(isToeplitzMatrix(b));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) return false;
        int rowCount = matrix.length;
        if (rowCount == 0) return true;
        int colCount = matrix[0].length;
        //对于行
        for (int row = 0; row < rowCount; row++) {
            int j = 1;
            int i = row + 1;
            while (j < colCount && i < rowCount) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        //对于列
        for (int col = 0; col < colCount; col++) {
            int i = 1;
            int j = col + 1;
            while (i < rowCount && j < colCount) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
                j++;
                i++;
            }
        }
        return true;
    }

    public static boolean isToeplitzMatrixRef(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i > 0 && j > 0 && a[i][j] != a[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
