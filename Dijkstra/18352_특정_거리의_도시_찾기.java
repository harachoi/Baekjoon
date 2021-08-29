import java.io.*;
import java.util.*;

public class Main {
    static class info {
        int city, dist;
        public info(int city, int cost) {
            this.city = city;
            this.dist = cost;
        }
    }

    static int N, M, K, X;
    static ArrayList<Integer> edge[];
    static ArrayList<Integer> result;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        //2. 그래프 만들기
        edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            edge[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edge[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        //3. X에서 K만큼 거리에 위치한 도시 찾기
        visit = new boolean[N + 1];
        result = new ArrayList<>();
        findPath(); //bfs

        //4. 결과 출력
        StringBuilder sb = new StringBuilder();
        Collections.sort(result);
        for (int i : result) sb.append(i + "\n");
        
        //최단 거리 도시가 존재 하지 않다면 return -1
        sb.append(result.size() == 0 ? "-1" : "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void findPath() {
        //시작점 방문으로 처리
        Queue<info> queue = new ArrayDeque<>();
        queue.offer(new info(X, 1));
        visit[X] = true;

        while (!queue.isEmpty()) {
            info current = queue.poll();
            for (int i = 0; i < edge[current.city].size(); i++) {
                if (!visit[edge[current.city].get(i)]) {
                    if (current.dist == K) result.add(edge[current.city].get(i));
                    queue.offer(new info(edge[current.city].get(i), current.dist + 1));
                    visit[edge[current.city].get(i)] = true;
                }
            }
        }
    }
}
