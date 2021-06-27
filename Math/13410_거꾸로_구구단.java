import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max = 0;
        for (int i = 1; i <= b; i++) {
            String str = new StringBuilder(String.valueOf(a * i)).reverse().toString();
            max = Math.max(max, Integer.parseInt(str));
        }
        System.out.println(max);
    }
}
