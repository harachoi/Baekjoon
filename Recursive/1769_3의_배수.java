import java.io.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        count = 0;
        int num = Integer.parseInt(search(n));
        System.out.println(count);
        System.out.println(num % 3 == 0 ? "YES" : "NO");
    }
    public static String search(String n) {
        int total = 0;
        if (n.length() > 1) {
            for (int i = 0; i < n.length(); i++) total += n.charAt(i) - '0';
            count++;
            return search(Integer.toString(total));
        } else return n;
    }
}
