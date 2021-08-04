import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int id, cost;
        public Edge(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, K;
    static ArrayList<Edge> adjList[];
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //1. 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //2. dijkstra
        dijkstra(K);

        //3. 결과 출력
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void dijkstra(int start) {
        //1. 시작점 PQ에 넣어주기
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > dist[now.id]) continue;

            int size = adjList[now.id].size();
            for (int i = 0; i < size; i++) {
                Edge next = adjList[now.id].get(i);
                if (dist[next.id] > now.cost + next.cost) {
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, dist[next.id]));
                }
            }

        }
    }
}
