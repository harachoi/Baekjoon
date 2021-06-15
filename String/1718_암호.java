import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String key = br.readLine();
        int keyIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') sb.append(" ");
            else if (str.charAt(i) - key.charAt(keyIndex) < 0) sb.append((char) ('z' - (key.charAt(keyIndex) - str.charAt(i))));
            else if (str.charAt(i) == key.charAt(keyIndex)) sb.append('z');
            else sb.append((char) ('a' +(str.charAt(i) - key.charAt(keyIndex) - 1)));

            keyIndex++;
            if (keyIndex == key.length()) keyIndex = 0;
        }
        System.out.println(sb);
    }
}
