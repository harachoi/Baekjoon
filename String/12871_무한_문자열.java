import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        if (s.length() == t.length()) System.out.println(s.endsWith(t) ? 1 : 0);
        else {
            int num = lcm(s.length(), t.length());
            String tmpS = "";
            String tmpT = "";

            for (int i = 0; i < num / s.length(); ++i) tmpS += s;
            for (int i = 0; i < num / t.length(); ++i) tmpT += t;
            System.out.println(tmpS.equals(tmpT) ? 1 : 0);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
