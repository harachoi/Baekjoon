import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static ArrayList<Integer> edge[];
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //1. 입력 받기
        N = Integer.parseInt(br.readLine());

        // 2^K > N인 K 찾기
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        //2. 그래프 만들기
        edge = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a].add(b);
            edge[b].add(a);
        }

        //3. set variables for LCA
        parent = new int[K][N + 1];
        depth = new int[N + 1];

        //4. depth 찾기
        dfs(1, 1);

        //5. fill parent
        fillParent();

        //6. LCA
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int id, int cnt) {
        //1. depth 저장
        depth[id] = cnt;

        //2. 자식들 depth 저장
        int size = edge[id].size();
        for (int i = 0; i < size; i++) {
            int next = edge[id].get(i);
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

    static int lca(int a, int b) {
        //1. let depth[a] >= depth[b]
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        //2. set to same depth
        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        //3. depth가 만났다면 end
        if (a == b) return a;

        //4. same depth but different parent
        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
