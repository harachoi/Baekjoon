import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][] isVisit;
    public static int n;
    public static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisit = new boolean[n][n];
        flag = false;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dfs(0,0) ? "HaruHaru" : "Hing");
    }

    public static boolean dfs(int dx, int dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{dx,dy});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];

            if (x + map[x][y] < n && !isVisit[x + map[x][y]][y]) {
                if (map[x + map[x][y]][y] == -1) return true;
                isVisit[x + map[x][y]][y] = true;
                queue.add(new int[] {x + map[x][y], y});
            }
            if (y + map[x][y] < n && !isVisit[x][y+ map[x][y]]) {
                if (map[x][y + map[x][y]] == -1) return true;
                isVisit[x][y + map[x][y]] = true;
                queue.add(new int[] {x, y + map[x][y]});
            }
        }
        return false;
    }
}
