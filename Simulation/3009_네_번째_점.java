import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] x = new int[1001];
        int[] y = new int[1001];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[Integer.parseInt(st.nextToken())]++;
            y[Integer.parseInt(st.nextToken())]++;
        }
        for (int i = 1; i < x.length; i++) {
            if (x[i] == 1) {
                sb.append(i);
                break;
            }
        }
        sb.append(" ");
        for (int i = 1; i < y.length; i++) {
            if (y[i] == 1) {
                sb.append(i);
                break;
            }
        }
        System.out.println(sb);
    }
}
