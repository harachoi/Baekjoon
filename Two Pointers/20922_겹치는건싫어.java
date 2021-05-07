import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[100001];
        int max = 0, index = 0;
        int[] given = new int[n + 1];
        for (int i = 0; i < n; i++) given[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            arr[given[i]]++;
            if (arr[given[i]] > k) {
                max = Math.max(max, i - index);
                while (arr[given[i]] > k) {
                    arr[given[index++]]--;
                }
            }
        }
        System.out.println(n - index > max ? n - index : max);
    }
}
