import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) n++;
        while (true) {
            StringBuilder sb = new StringBuilder(String.valueOf(n));
            StringBuilder reverse = new StringBuilder(sb.reverse());
            if (sb.reverse().toString().compareTo(reverse.toString()) == 0) {
                if (!isPrime(n)) {
                    System.out.println(n);
                    return;
                }
                n++;
            } else n++;
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) return true;
        }
        return false;
    }
}
