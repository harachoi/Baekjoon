import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int[] arr;
    public static int[] input;
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = 6;
            if (n == 0) break;
            input = new int[n];
            for (int i = 0; i < n; i++) input[i] = Integer.parseInt(st.nextToken());
            arr = new int[6];
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < n; i++) {
            arr[depth] = input[i];
            dfs(i + 1, depth + 1);

        }
    }
}
