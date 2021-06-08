import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!set.contains(num)) {
                set.add(num);
                list.add(num);
            }
        }
        Collections.sort(list);
        for (int i : list) sb.append(i).append(" ");
        System.out.println(sb);
    }
}
