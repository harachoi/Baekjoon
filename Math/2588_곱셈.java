import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        String numStr = String.valueOf(b);
        for (int i = numStr.length() - 1; i >= 0; i--) {
            sb.append((a * (numStr.charAt(i) - '0'))).append("\n");
        }
        sb.append(a * b);
        System.out.println(sb);
    }
}
