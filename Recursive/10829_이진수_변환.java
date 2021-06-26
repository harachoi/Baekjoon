import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        BigInteger n = new BigInteger(br.readLine());
        toBin(n);
        System.out.println(sb.reverse());
    }
    public static void toBin(BigInteger n) {
        if (n == BigInteger.valueOf(0) || n == BigInteger.valueOf(1)) {
            if (n == BigInteger.valueOf(1)) sb.append(n);
            return;
        }
        sb.append(n.mod(BigInteger.valueOf(2)));
        toBin(n.divide(BigInteger.valueOf(2)));
    }
}
