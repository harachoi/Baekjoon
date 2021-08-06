import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i - 2] + zero[i - 1];
            one[i] = one[i - 2] + one[i - 1];
        }
        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(zero[a] + " " + one[a] + "\n");
        }
        System.out.println(sb);
    }
}
