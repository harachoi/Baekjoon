import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //1. 입력 저장하기
        N = Integer.parseInt(br.readLine());

        //2. 그래프 INF로 초기화하기
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        //3. a to b 1로 설정하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) dist[i][j] = 1;
            }
        }

        //4. Floyd-Warshall
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = dist[i][j] <= dist[i][k] + dist[k][j] ? dist[i][j] : 1;//dist[i][k] + dist[k][j];
                }
            }
        }

        //5. 결과 출력
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) { 
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
