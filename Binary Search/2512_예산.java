import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long m = Long.parseLong(br.readLine());
        long answer = 0;
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        long start = 0;
        long end = arr[arr.length - 1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] < mid) total += arr[i];
                else total += mid;
            }
            if (total > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
