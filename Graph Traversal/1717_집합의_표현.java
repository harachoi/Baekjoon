import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i<= n; i++) {
            parent[i] = i;
        }

        for (int read = 0; read < m; read++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                Union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(sb);
    }
    static void Union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }

    static int find(int id) {
        if (parent[id] == id) return id;
        return parent[id] = find(parent[id]);
    }
}
