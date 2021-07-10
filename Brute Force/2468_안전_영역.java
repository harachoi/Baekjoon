import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static boolean[][] isVisit;
    static int n, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int graphMax = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }
        for (int lim = 0; lim < max; lim++) {
            isVisit = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isVisit[i][j] || arr[i][j] <= lim) continue;
                    dfs(i, j, lim);
                    count++;
                }
            }
            graphMax = Math.max(graphMax, count);
        }

        System.out.println(graphMax);
    }
    public static void dfs(int x, int y, int limit) {
        isVisit[x][y] = true;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if (!isVisit[nextX][nextY] && arr[nextX][nextY] > limit) {
                dfs(nextX, nextY, limit);
            }
        }
    }
}
