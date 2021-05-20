import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][] isVisit;
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = 0;
        map = new int[n][m];
        isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        int[] dx = {0,0,-1,1,-1,-1,1,1};
        int[] dy = {-1,1,0,0,-1,1,-1,1};
        isVisit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                if (!isVisit[xx][yy] && map[xx][yy] == 1) dfs(xx,yy);
            }
        }
    }
}
