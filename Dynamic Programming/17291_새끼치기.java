import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]dp = new int[21];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        
        for (int i = 2; i < n; i++) {
            if (i % 2 == 1) dp[i+1] = dp[i] + dp[i-1] + dp[i-2];
            else dp[i+1]= dp[i] * 2;
        }
        System.out.println(dp[n]);
    }
}
