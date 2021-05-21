import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            check[a][b] = true;
            check[b][a] = true;
        }

        int count = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                if(check[i][j]) continue;
                for(int k = j+1; k < n; k++) {
                    if(check[i][k] || check[j][k]) continue;;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
