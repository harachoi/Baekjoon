import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] input;
    public static int n, m, max, b;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        b = Integer.parseInt(st.nextToken());
        n = a.length();
        m = a.length();
        max = -1;
        input = new int[n];
        visit = new boolean[n];
        if (a.length() > String.valueOf(b).length()) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            input[i] = a.charAt(i) - '0';
        }
        Arrays.sort(input);
        arr = new int[m];

        dfs(0);
        System.out.println(String.valueOf(max).length() < a.length() ? -1 : max);
    }

    public static void dfs(int depth) {
        String num = "";
        if (depth == m) {
            for (int val : arr) {
                num += val;
            }
            if (Integer.valueOf(num) <= b) {
                max = Math.max(Integer.parseInt(num), max);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
