import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] table;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        table = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            for (int j = 0; j < m; j++) {
                if (sb.charAt(j) == 'W') {
                    table[i][j] = true;
                }
            }
        }

        int endN = n - 7;
        int endM = m - 7;
        for (int i = 0; i < endN; i++) {
            for (int j =0; j < endM; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        boolean start = table[x][y];
        int count = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (table[i][j] != start) {
                    count++;
                }

                start = (!start);
            }
            start = !start;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
