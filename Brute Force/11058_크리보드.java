import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        for (int i = 7; i <= n; i++) {
            for (int j = 3; j <= i; j++) {
                long printed = dp[i - j];
                long buf = dp[i-j];
                int cnt  = j - 2;
                dp[i] = Math.max(dp[i],printed+(buf*cnt));
            }
        }
        System.out.println(dp[n]);
    }
}
