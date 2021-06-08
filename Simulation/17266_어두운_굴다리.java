import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = arr[0];
        for (int i = 1; i < m; i++) max = Math.max((arr[i] - arr[i - 1] + 1) / 2, max);
        System.out.println(Math.max(max, n - arr[arr.length - 1]));
    }
}
