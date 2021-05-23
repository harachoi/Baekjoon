import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] numList = new boolean[10001];
        for (int i = 1; i <= 9994; i++) {
            String str = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < str.length(); j++) sum += str.charAt(j) - '0';
            if (sum + i == 9994) break;
            numList[sum + i] = true;
        }

        for (int i = 1; i < 9994; i++) sb.append(!numList[i] ? i + "\n" : "");
        System.out.println(sb);
    }
}
