import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet set = new LinkedHashSet();

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            if (arr[left] + arr[right] == x) {
                count++;
            }
            if (arr[left] + arr[right] <= x) {
                left++;
            } else right--;
        }
        System.out.println(count);
    }
}
