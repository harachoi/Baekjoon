import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int prev = Integer.MIN_VALUE;
            int total = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                total += num;
                prev = Math.max(prev, total);
                if (total < 0) total = 0;
            }
            sb.append(prev).append("\n");
        }
        System.out.print(sb);
    }
}
