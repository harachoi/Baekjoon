import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int min, max;

    static ArrayList[] tree;
    static int[] depth;
    static int[][] parent;
    static StringBuilder sb;
    static int[][] minDist;
    static int[][] maxDist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        //1. Initialize variables
        N = Integer.parseInt(br.readLine());

        //2. 2^K
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        //3. Set variables for tree & LCA
        depth = new int[N + 1];
        parent = new int[K][N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<Dist>();
        }

        // 도로 네트워크 변수 초기화
        minDist = new int[K][N + 1];
        maxDist = new int[K][N + 1];

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            tree[a].add(new Dist(b, dist));
            tree[b].add(new Dist(a, dist));
        }

        //4. set depth using DFS
        dfs(1, 1);

        //5. fill parent
        fillParent();

        //6. LCA
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            LCA(a, b);
            sb.append(min+" "+max+"\n");
        }

        System.out.print(sb);
    }

    static void dfs(int id, int cnt) {
        //1. depth 기록
        depth[id] = cnt;

        //2. 자식들 depth 기록
        int size = tree[id].size();
        for (int i = 0; i < size; i++) {
            Dist next = (Dist) tree[id].get(i);
            if (depth[next.target] == 0) {
                dfs(next.target, cnt + 1);
                parent[0][next.target] = id;

                minDist[0][next.target] = next.dist; // 현재 cost로 갱신
                maxDist[0][next.target] = next.dist; // 현재 cost로 갱신
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];

                // 도로네트워크 추가
                minDist[i][j] = Math.min( minDist[i-1][j], minDist[i-1][parent[i-1][j]]);
                maxDist[i][j] = Math.max( maxDist[i-1][j], maxDist[i-1][parent[i-1][j]]);
            }
        }
    }

    static void LCA(int a, int b) {
        //1. set depth[a] >= depth[b]
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        min = Integer.MAX_VALUE;
        max = -1;

        //2. set to equal depth
        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                min = Math.min(min, minDist[i][a]);
                max = Math.max(max, maxDist[i][a]);

                a = parent[i][a];
            }
        }

        //3. if a == b
        if (a == b) return;

        //4. same depth but different parent
        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));

                a = parent[i][a];
                b = parent[i][b];
            }
        }

        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));
        return;
    }
}

class Dist {
    int target;
    int dist;
    Dist(int target, int dist) {
        this.target = target;
        this.dist = dist;
    }
}
