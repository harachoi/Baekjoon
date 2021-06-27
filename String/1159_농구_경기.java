import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            alpha[str.charAt(0) - 'a']++;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] >= 5) sb.append((char) (i + 'a'));
        }
        System.out.println(sb.length() != 0 ? sb : "PREDAJA");
    }
}
