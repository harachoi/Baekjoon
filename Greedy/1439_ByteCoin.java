import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        char tmp = '2';
        int zero = 0, one = 0;
        for (int i = 0; i < a.length(); i++) {
            if ('0' == a.charAt(i) && tmp != '0') {
                zero++;
                tmp = '0';
            } else if ('1' == a.charAt(i) && tmp != '1') {
                one++;
                tmp = '1';
            }
        }
        System.out.println(zero > one ? one : zero);
    }
}
