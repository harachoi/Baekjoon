import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1. 입력 저장하기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        //2. 최대 값 구하기
        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        
        if (n >= 2) dp[2] = dp[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
        }

        //3. 결과 출력하기
        bw.write(String.valueOf(dp[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}
