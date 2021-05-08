import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        int p = 1;
        if (n % 2 != 0) {
            check = true;
            n -= 1;
        }
        for (int i = 0; i < n; i++) {
            sb.append(p + " ");
            if (p == 1) p = 2;
            else p = 1;
        }
        if (check) sb.append(3);
        System.out.println(sb);
    }
}
