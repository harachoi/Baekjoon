import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
