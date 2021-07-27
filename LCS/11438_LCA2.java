import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static ArrayList<Integer> graph[];
    static int[][] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;


        // 1. 2^K > N인 K 찾기
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        // 2. build graph
        parent= new int[K][N + 1];
        depth = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 3. DFS to find depth for each node
        dfs(1, 1);

        // 4. fill in parent[][]
        fillParent();

        // 5. LCS
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    //depth 확인 DFS
    static void dfs(int id, int cnt) {
        //1. depth 기록
        depth[id] = cnt;

        //2. 자실들의 depth 기록
        int size = graph[id].size();
        for (int i = 0; i < size; i++) {
            int next = graph[id].get(i);
            if (depth[next] == 0) {
                dfs(next, cnt + 1);
                parent[0][next] = id;
            }
        }
        return;
    }

    static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int LCA(int a, int b) {
        // 1. depth[a] >= depth[b] 이도록 조정하기
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 2. 더 깊은 a를 2^K승 점프하여 depth를 맞추기
        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i)<= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        // 3. depth를 맞췄는데 같다면 종료
        if (a == b) return a;

        // 4. a-b는 같은 depth이므로 2^K승 점프하며 공통부모 바로 아래까지 올리기
        //같은 depth 이면서 조상이 다를 때
        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
