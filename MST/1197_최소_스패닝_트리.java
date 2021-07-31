import java.io.*;
import java.util.*;

public class Main {
    static class info implements Comparable<info>{
        int start, target, cost;
        public info(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(info o) {
            return this.cost - o.cost;
        }
    }

    static int V, E;
    static PriorityQueue<info> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1.입력 받기
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //2. set parent
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        //2. 그래프 만들기
        pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //3. find MST using pq & union and find
        int ans = 0;
        for (int i = 0; i < E; i++) {
            info cur = pq.poll();

            int a = find(cur.start);
            int b = find(cur.target);
            if (a == b) continue;

            union(cur.start, cur.target);
            ans += cur.cost;
        }

        //4. 결과 출력하기
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    static int find(int id) {
        if (parent[id] == id) return id;
        return parent[id] = find(parent[id]);
    }
}
