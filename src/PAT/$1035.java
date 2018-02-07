package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class $1035 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine().trim());
            Vector<Account> vector = new Vector<>();
            for (int i = 0; i < count; i++) {
                String[] strArr = reader.readLine().split(" ");
                if (isNeedModified(strArr[1])) {
                    vector.add(new Account(strArr[0], strArr[1]));
                }
            }
            if (vector.size() == 0) {
                if (count == 1) System.out.println("There is 1 account and no account is modified");
                else System.out.println("There are " + count + " accounts and no account is modified");
            } else {
                modifiedAndPrint(vector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void modifiedAndPrint(Vector<Account> vector) {
        int size = vector.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            Account account = vector.get(i);
            char[] chars = account.psw.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') chars[j] = '@';
                else if (chars[j] == '0') chars[j] = '%';
                else if (chars[j] == 'l') chars[j] = 'L';
                else if (chars[j] == 'O') chars[j] = 'o';
            }
            System.out.println(account.id + " " + new String(chars));
        }
    }

    static boolean isNeedModified(String s) {
        if (s.contains("1")) return true;
        if (s.contains("0")) return true;
        if (s.contains("l")) return true;
        if (s.contains("O")) return true;
        return false;
    }
}

class Account {

    public Account(String p0, String p1) {
        id = p0;
        psw = p1;
    }

    String id;
    String psw;
}
