import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            String monster = br.readLine();
            map.put(monster, String.valueOf(i));
            map.put(String.valueOf(i), monster);
        }
        for (int i = 0; i < m; i++)  sb.append(map.get(br.readLine().toString())).append("\n");
        System.out.println(sb);
    }
}
