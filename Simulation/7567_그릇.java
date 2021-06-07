import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        char curr = sb.charAt(0);
        int height = 10;
        for (int i = 1; i < sb.length(); i++) {
            if (curr != sb.charAt(i)) {
                curr = sb.charAt(i);
                height += 10;
            } else height += 5;
        }
        System.out.println(height);
    }
}
