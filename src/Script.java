import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Script {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bf.readLine();
            System.out.println("input：" + str);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
