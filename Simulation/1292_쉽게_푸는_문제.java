import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int base = 1;
        int count = 0;
        int total = 0;
        for (int i = 1; i <= b; i++) {
            if (i >= a) total += base;
            count++;
            if (count == base) {
                base++;
                count = 0;
            }
        }
        System.out.println(total);
    }
}
