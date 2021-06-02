import java.io.*;

public class Main {
    public static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n + 1];
        if (n == 0) System.out.println(1);
        else if (n == 1) System.out.println(1);
        else {
            fac(n);
            System.out.println(list[n]);
        }
    }
    public static void fac(int num) {
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i <= num; i++) list[i] = list[i - 1] * i;
    }
}
