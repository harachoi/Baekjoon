import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long q = (long) Math.sqrt(n);
        while (true) {
            if (n <= Math.pow(q, 2)) break;
            else q++;
        }
        System.out.println(q);
    }
}
