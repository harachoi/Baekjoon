import java.io.*;
import java.util.*;

public class Main {
    public static int low, high;
    public static int n, m, result;
    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        low = 1; high = 0; result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }
        binarySearch();
        System.out.println(result);
    }
    private static void binarySearch() {
        int mid, count;

        while (low <= high) {
            mid = (low + high) / 2;
            count = 0;

            for (int i = 0; i < m; i++) {
                int temp = arr[i] % mid == 0 ? arr[i] / mid : arr[i] / mid + 1;
                count += temp;
            }

            if (n >= count) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}
