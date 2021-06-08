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
        low = 1; high = Integer.MIN_VALUE; result = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(arr[i], high);
        }
        binarySearch();
        System.out.println(result == Integer.MIN_VALUE ? 0 : result);
    }
    private static void binarySearch() {
        int mid, count;

        while (low <= high) {
            mid = (low + high) / 2;
            count = 0;

            for (int i = 0; i < m; i++) count += arr[i] / mid;
            if (n <= count) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
