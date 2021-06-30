import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int left = 0, right = 0;
        int total = 0;
        int count = 0;
        
        while (true) {
            if (total < m) {
                if (right == n) break;
                total += arr[right++];
            }
            else if (total > m) total -= arr[left++];
            else {
                count++;
                if (right == n) break;
                total += arr[right];
                right++;
            }
        }
        System.out.println(count);
    }
}
