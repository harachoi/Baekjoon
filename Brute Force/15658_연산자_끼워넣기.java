import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr,symbols;
    static int max,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        symbols = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            symbols[i] = Integer.parseInt(st.nextToken());

        // 최대 최소 값 초기화
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        search(1,arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void search(int idx, int sum) {
        if (idx >= n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (symbols[i] == 0) continue;
            symbols[i]--;
            switch (i) {
                case 0: // +
                    search(idx + 1, sum + arr[idx]);
                    break;
                case 1: // -
                    search(idx + 1, sum - arr[idx]);
                    break;
                case 2: // *
                    search(idx + 1, sum * arr[idx]);
                    break;
                case 3: // /
                    search(idx + 1, sum / arr[idx]);  
                    break;
            }
            symbols[i]++;
        }
    }
}
