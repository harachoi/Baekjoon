import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minusOne = 0;
        int divTwo = 0;

        for (int i = 0; i < n; i++) {
            int tmpDivTwo = 0;
            while (arr[i] != 0) {
                if (arr[i] % 2 != 0) {
                    arr[i]--;
                    minusOne++;
                } else {
                    tmpDivTwo++;
                    arr[i] /= 2;
                }
            }
            divTwo = Math.max(divTwo, tmpDivTwo);
        }
        System.out.println(divTwo + minusOne);
    }
}
