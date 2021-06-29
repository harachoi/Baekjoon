import java.io.*;
import java.util.*;

public class Main {
    static HashSet<String> set;
    static int n, k;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        search(0, "");
        System.out.println(set.size());
    }

    public static void search(int depth, String s) {
        if (depth == k) {
            set.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                search(depth + 1, s +arr[i]);
                visit[i] = false;
            }
        }
    }
}
