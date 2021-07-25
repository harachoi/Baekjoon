import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    static Deque<Point> waterPos;
    static Deque<Point> sPos;
    static char[][] map;
    static boolean[][] visit;
    static boolean checkD;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];
        waterPos = new ArrayDeque<>();
        sPos = new ArrayDeque<>();
        count = 0;

        //build map
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') waterPos.addLast(new Point(i, j));
                else if (map[i][j] == 'S') sPos.addLast(new Point(i, j));
            }
        }

        //search path
        checkD = false;
        dfs();

        System.out.println(checkD ? count : "KAKTUS");
    }

    public static void dfs() {
        while (!sPos.isEmpty()) {
            int size = sPos.size();
            for (int pos = 0; pos < size; pos++) {
                Point s = sPos.pollFirst();
                if (visit[s.x][s.y]) {
                    continue;
                }
                visit[s.x][s.y] = true;
                for (int i = 0; i < 4; i++) {
                    int mx = dx[i] + s.x;
                    int my = dy[i] + s.y;
                    if (mx >= 0 && mx < r && my >= 0 && my < c) {
                        if (map[mx][my] == '.' && !visit[mx][my]) {
                            sPos.addLast(new Point(mx, my));
                        } else if (map[mx][my] == 'D') {
                            checkD = true;
                            count++;
                            return;
                        }
                    }
                }
            }
            count++;
            updateWater();
        }

    }

    public static void updateWater() {
        int size = waterPos.size();
        for (int i = 0; i < size; i++) {
            Point water = waterPos.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = dx[k] + water.x;
                int my = dy[k] + water.y;
                if (mx >= 0 && mx < r && my >= 0 && my < c) {
                    if (map[mx][my] == '.') {
                        map[mx][my] = '*';
                        visit[mx][my] = true;
                        waterPos.addLast(new Point(mx, my));
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
