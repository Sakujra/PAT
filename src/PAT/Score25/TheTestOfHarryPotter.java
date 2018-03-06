package PAT.Score25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheTestOfHarryPotter {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = reader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (i == j) matrix[i][j] = 0;
                    else matrix[i][j] = 200;

            for (int i = 0; i < M; i++) {
                strings = reader.readLine().split(" ");
                int first = Integer.parseInt(strings[0]) - 1;
                int second = Integer.parseInt(strings[1]) - 1;
                int weight = Integer.parseInt(strings[2]);
                matrix[first][second] = weight;
                matrix[second][first] = weight;
            }

            for (int k = 0; k < N; k++)
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        if (matrix[i][j] > matrix[i][k] + matrix[k][j])
                            matrix[i][j] = matrix[i][k] + matrix[k][j];

            int minLength = 200;
            int least = 0;
            for (int i = 0; i < N; i++) {
                int maxLength = 0;
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > maxLength)
                        maxLength = matrix[i][j];
                }
                if (maxLength < minLength) {
                    minLength = maxLength;
                    least = i;
                }
            }
            System.out.println((least + 1) + " " + minLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
