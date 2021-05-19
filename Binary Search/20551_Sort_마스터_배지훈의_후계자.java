import java.io.*;
import java.util.*;
public class Main {
    public static int[] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            if (!set.contains(num)) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(search(num)).append("\n");
        }
        System.out.println(sb);
    }
    public static int search (int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
