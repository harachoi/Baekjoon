import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String n = br.readLine();
        octalToBin(n);
        System.out.println(sb);
    }
    public static void octalToBin(String n) {
        for (int i = 0;  i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (i != 0 && num <= 1)
                sb.append("00");
            else if (i != 0 && (num == 2 || num == 3))
                sb.append("0");
            sb.append(Integer.toBinaryString(num));
        }
    }
}
