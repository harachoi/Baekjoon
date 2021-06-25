import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(x + 1).replace('0', '4').replace('1', '7'));
        sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
