import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            //build board
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    board[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + board[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + board[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(sb);
    }
}
