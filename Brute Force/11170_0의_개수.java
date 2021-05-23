import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = n; j <= m; j++) {
                String strNum = String.valueOf(j);
                if (strNum.contains("0")) {
                    for (int k = 0; k < strNum.length(); k++) {
                        if (strNum.charAt(k) == '0') count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
