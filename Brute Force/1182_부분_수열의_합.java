import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] numList;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 입력 받기
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        //build array
        st = new StringTokenizer(br.readLine());
        numList = new int[N];
        for (int i = 0; i < N; i++)
            numList[i] =Integer.parseInt(st.nextToken());


        //2. 백트리킹을 사용해 S를 만드는 모든 경우 찾기
        dfs(0, 0);

        if (S == 0) count--;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(depth + 1, sum + numList[depth]);
        dfs(depth + 1, sum);
    }
}
