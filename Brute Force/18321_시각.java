import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int sec = 0;

        for (int i = 0; i < 60; i++)
            if (i % 10 == m || i / 10 == m) sec++;

        for (int hour = 0; hour <= n; hour++) {
            if (hour %10 == m || hour / 10 ==m)  count += 60*60;
            else {
                for (int min = 0; min < 60; min++) {
                    if (min %10 == m || min / 10 ==m) count += 60;
                    else count += sec;
                }
            }
        }
        System.out.println(count);
    }
}
