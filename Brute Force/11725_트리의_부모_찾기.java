import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static ArrayList<Integer> arr[];
    static int[] result;
    static boolean[] isVisit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        result = new int[n+1];
        isVisit = new boolean[n + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisit[i]) {
                dfs(i);
            }
        }
        for (int i = 2; i < result.length; i++) sb.append(result[i] + "\n");
        System.out.print(sb);
    }

    public static void dfs(int index) {
        isVisit[index] = true;
        for (int i : arr[index]) {
            if (!isVisit[i]) {
                result[i] = index;
                dfs(i);
            }
        }
    }
}
