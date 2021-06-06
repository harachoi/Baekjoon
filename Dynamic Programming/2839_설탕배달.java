import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if (n < 3 || n == 4) {
            System.out.println(-1);
            return;
        }

        while (n > 0) {
            if (n % 5 == 0) {
                n -= 5;
                count++;
            } else {
                n-=3;
                count++;
            }
        }
        
        if (n != 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
