import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int cmd = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[21];
        long[] dp = new long[21];

        //build dp
        dp[0] = 1;
        for (int i = 1; i < 21; i++) {
            dp[i] = dp[i - 1] * i;
        }

        // find permutation
        if (cmd == 1) { // case 1
            long K = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue;
                    if (dp[N - i - 1] < K) K -= dp[N - i - 1];
                    else {
                        sb.append(j + " ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb);
        } else { //case 2
            //build array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if(!visited[j]) {
                        ans += dp[N-i-1];
                    }
                }
                visited[arr[i]] = true;
            }
            System.out.println(ans);
        }
    }
}
