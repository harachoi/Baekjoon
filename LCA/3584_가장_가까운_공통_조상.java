import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Integer> edge[];
    static int[] depth;
    static int[][] parent;
    static boolean[] checkRoot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //run test
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //1. 입력 저장하기
            N = Integer.parseInt(br.readLine());

            //2. 2^K 구하기
            K = 0;
            for (int i = 1; i <= N; i *= 2) {
                K++;
            }

            //3. build tree
            depth = new int[N + 1];
            parent = new int[K][N + 1];
            edge = new ArrayList[N + 1];
            checkRoot = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                edge[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edge[a].add(b);
                edge[b].add(a);
                checkRoot[b] = true;
            }

            //4. 루트 노드 찾기
            int root = 0;
            for(int j = 1; j <= N; j++) {
                if(checkRoot[j] == false) {
                    root = j;
                    break;
                }
            }

            //5. depth 설정하기
            dfs(root, 1);

            //6. fill parent
            fillParent();

            //7. LCA
            st = new StringTokenizer(br.readLine());
            sb.append(LCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
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
    }

    static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N ; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int LCA(int a, int b) {
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

        //3. check they have same parent
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
