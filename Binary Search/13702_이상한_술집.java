import java.io.*;
import java.util.*;

public class Main {
    public static long low, high, result;
    public static int n, m;
    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m];
        low = 1; high = Integer.MIN_VALUE; result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(arr[i], high);
        }
        binarySearch();
        System.out.println(high);
    }
    private static void binarySearch() {
        long mid, count;

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
