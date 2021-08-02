import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //1. 파도반 수열 만들기
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        //2. 테스트 케이스 수 만큼 run 하기
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        //3. 결고 배출
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
