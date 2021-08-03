import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //1. 입력 받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //1-1 INF로 초기화하기
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        //1-2 a to b 의 cost 저장하기
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], Integer.parseInt(st.nextToken()));
        }

        //2. Floyd-Warshall
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    dist[i][j] = dist[i][j] <= dist[i][k] + dist[k][j] ? dist[i][j] : dist[i][k] + dist[k][j];
                }
            }
        }

        //3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) sb.append(0 + " ");
                else sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
