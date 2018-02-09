package PAT.Score20;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $1073 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder builder = new StringBuilder();
            String input = reader.readLine();
            if (input.charAt(0) == '-') builder.append("-");

            StringBuilder builderBody = new StringBuilder();
            int i = 1;
            for (i = 1; ; i++) {
                char c = input.charAt(i);
                if (c == 'E') break;
                builderBody.append(c);
            }
            int offset = i - 3;
            i++;
            boolean isInt = false;
            if (input.charAt(i) == '+') isInt = true;
            int zeroCount = Integer.parseInt(input.substring(i + 1));
            if (zeroCount == 0) {
                builder.append(builderBody);
            } else {
                builderBody.deleteCharAt(1);
                if (isInt) {
                    builder.append(builderBody);
                    for (int j = 0; j < zeroCount - offset; j++) {
                        builder.append('0');
                    }
                } else {
                    builder.append("0.");
                    for (int j = 0; j < zeroCount - 1; j++) {
                        builder.append('0');
                    }
                    builder.append(builderBody);
                }
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
