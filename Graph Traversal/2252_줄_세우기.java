import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static ArrayList<Integer> edge[];
    static StringBuilder sb;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];

        edge = new ArrayList[n  + 1];
        for (int i = 0; i < n + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a < b
            edge[a].add(b);

            //degree graph
            indegree[b]++;
        }

        //2. 진입차수 (indegree)를 0인애들 Queue에 넣기
        queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        dfs();
        System.out.println(sb);
    }
    public static void dfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current + " ");

            int size = edge[current].size();
            for (int i = 0; i < size; i++) {
                //연결된 간선
                int target = edge[current].get(i);
                // 1) 진입차수 indegree - 1
                indegree[target]--;
                if (indegree[target] == 0) {
                    queue.add(target);
                }
            }
        }
    }
}
