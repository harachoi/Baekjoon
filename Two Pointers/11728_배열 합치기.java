import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + m];
        StringTokenizer ast = new StringTokenizer(br.readLine());
        StringTokenizer bst = new StringTokenizer(br.readLine());
        for (int i = 0; i < m + n; i++) {
            if (i < n) arr[i] = Integer.parseInt(ast.nextToken());
            else arr[i] = Integer.parseInt(bst.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) sb.append(arr[i] + " ");
        System.out.println(sb);
    }
}
