import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int start, target, cost;

        public Edge(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }
    }

    static int N, M;
    static Edge[] edgeList;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //2. 시작점 1을 제외한 나머지 초기화하기
        dist = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = INF;
        }

        //3. Bellman Ford & 출력하기
        if (bellmanFord()) sb.append(-1);
        else {
            for (int i = 2; i <= N; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellmanFord() {
        //1. N - 1만큼 간선 M 모두 확인
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = edgeList[j];

                if (dist[cur.start] == INF) continue;

                dist[cur.target] = Math.min(dist[cur.target], dist[cur.start] + cur.cost);
            }
        }

        //2. 마지막으로 간선 M을 확인
        for (int i = 0; i < M; i++) {
            Edge cur = edgeList[i];

            if (dist[cur.start] == INF) continue;

            //갱신이 발생한다면 무한루프
            if (dist[cur.start] + cur.cost < dist[cur.target]) return true;
        }
        return false;
    }
}
