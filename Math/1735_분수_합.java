import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int numerator = (a*d) + (c*b);
        int denominator = b * d;
        int div = gcd(numerator, denominator);

        System.out.println((numerator /= div) + " " + (denominator /= div));
    }

    public static int gcd(int a, int b) {
        if (a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }
}
