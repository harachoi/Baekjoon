import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String[] str = new String[5];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            str[i] = br.readLine();
            max = Math.max(max, str[i].length());
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < str[j].length()) {
                    result.append(str[j].charAt(i));
                }
            }
        }
        System.out.println(result);
    }
}
