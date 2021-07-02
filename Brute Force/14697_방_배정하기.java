import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        System.out.println(search() ? 1 : 0);
    }

    public static boolean search() {
        int num = 0;
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    num = i * arr[0] + j * arr[1] + k * arr[2];
                    if (num == n) return true;
                }
            }
        }
        return false;
    }
}
