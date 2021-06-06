import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if ((n/3 + n%3) % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
