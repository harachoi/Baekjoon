import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
        }
        Arrays.sort(arr);
        if (n == 2) {
            for (int i = 1; i <= arr[0] / 2; i++) {
                if (arr[0] % i == 0 && arr[1] % i == 0) sb.append(i + "\n");
            }
            if (arr[1] % arr[0] == 0) sb.append(arr[0] + "\n");
        } else {
            for (int i = 1; i <= arr[0] / 2; i++) {
                if ((arr[0] % i == 0) && (arr[1] % i == 0) && (arr[2] % i == 0)) sb.append(i + "\n");
            }
            if (arr[1] % arr[0] == 0 && arr[2] % arr[0] == 0) sb.append(arr[0] + "\n");
        }
        System.out.println(sb);
    }
}
