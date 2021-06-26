import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean check = false;
        for (int k = 0; k < m - 1; k++) {
            for (int p = k + 1; p < m; p++) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (arr[k][i] < arr[k][j]) {
                            if (arr[p][i] >= arr[p][j]) check = true;
                        }
                        if (arr[k][i] > arr[k][j]) {
                            if (arr[p][i] <= arr[p][j] ) check = true;
                        }
                        if (arr[k][i] == arr[k][j]) {
                            if (arr[p][i] != arr[p][j]) check = true;
                        }
                    }
                    if (check) break;
                }
                if (!check) count++;
                check = false;
            }
        }
        System.out.println(count);
    }
}
