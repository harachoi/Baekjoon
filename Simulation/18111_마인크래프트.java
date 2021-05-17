import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        int storeHeight = 0;
        long sum = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        long maxHeight = (sum + b) / (n * m) > 256 ? 256 : (sum + b) / (n * m);
        long minTime = Integer.MAX_VALUE;

        for (int h = 0; h <= maxHeight; h++) {
            long tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] < h) tmp = tmp + h - map[i][j];
                    else if (map[i][j] > h) tmp = tmp + (map[i][j] - h) * 2;
                }
            }
            if (minTime >= tmp) {
                minTime = tmp;
                storeHeight = h;
            }
        }
        System.out.println(minTime + " " + storeHeight);
    }
}
