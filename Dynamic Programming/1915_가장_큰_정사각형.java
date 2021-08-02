import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 입력 저장하기 & build map
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                //2. map에 숫자 저장하기
                dp[i + 1][j + 1] = str.charAt(j) - '0';

                //3. 정사각형인지 확인하기
                if(dp[i + 1][j + 1] != 0){
                    int temp = Math.min(dp[i][j], dp[i][j + 1]);
                    dp[i + 1][j + 1] = Math.min(temp, dp[i + 1][j]) + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        
        bw.write(String.valueOf(max * max));
        bw.flush();
        bw.close();
        br.close();
    }
}
