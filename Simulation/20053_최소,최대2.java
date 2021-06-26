import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            sb.append(min + " " + max).append("\n");
        }
        System.out.print(sb);
    }
}
