import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        prime = new boolean[n + 1];
        getPrime();

        for (int i = m ; i <= n; i++) {
            if (!prime[i]) result.append(i).append("\n");
        }
        System.out.println(result);
    }

    public static void getPrime () {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
