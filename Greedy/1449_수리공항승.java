import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int count = 0, p = arr[0];
        for (int i = 1; i < n; i++) {
            if(p + l < arr[i]) {
                count++;
                p = arr[i];
            }
        }
        if (p + l >= arr[arr.length - 1]) count++;
        System.out.println(count);
    }
}
