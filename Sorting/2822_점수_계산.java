import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int total = 0;
        int[] arr = new int[9];
        int[] sort = new int[9];

        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sort[i] = arr[i];
            set.add(arr[i]);
        }
        Arrays.sort(sort);
        for (int i = 1; i <= 3; i++) {
            set.remove(sort[i]);
        }
        for (int i = 1; i <= 8; i++) {
            if (set.contains(arr[i])) {
                sb.append(i + " ");
                total += arr[i];
            }
        }
        System.out.println(total);
        System.out.println(sb);
    }
}
