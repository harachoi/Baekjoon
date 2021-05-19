import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] nArr = new int[n];
            int[] mArr = new int[m];
            for (int j = 0; j < n; j++) {
                nArr[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mArr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(mArr);
            int mid = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                int left = 0;
                int right = m - 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (nArr[j] > mArr[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (right >= 0) {
                    count += right + 1;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
