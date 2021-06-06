import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fibonacci(Integer.parseInt(br.readLine())));
    }
    public static long fibonacci(int n) {
        long[] s = new long[10000];
        s[0] = 0;
        s[1] = 1;
        for (int i = 2; i <= n; i++) {
            s[i] = s[i - 2] + s[i - 1];
        }
        return s[n];
    }
}
