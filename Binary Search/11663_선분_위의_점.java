import java.io.*;
import java.util.*;

public class Main {
    public static int low, high, result;
    public static int n, m;
    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int indexA = binarySearch(a);
            int indexB = binarySearchEnd(b);
            
            sb.append(indexB - indexA + 1).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int binarySearch(int search) {
        int mid = 0;
        low = 0; high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] <= search) {
                if (arr[mid] == search) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private static int binarySearchEnd(int search) {
        int mid = 0;
        low = 0; high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] <= search) {
                if (arr[mid] == search) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }
}
