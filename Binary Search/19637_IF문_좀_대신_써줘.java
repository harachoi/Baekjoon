import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] state = new String[n];
        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            state[i] = st.nextToken();
            limit[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n;
            while (left <= right) {
                int mid = ((left + right) / 2);
                if (num > limit[mid]) left = mid + 1;
                else if (num <= limit[mid]) right = mid - 1;
            }
            sb.append(state[left] + "\n");
        }
        System.out.println(sb);
    }
}
