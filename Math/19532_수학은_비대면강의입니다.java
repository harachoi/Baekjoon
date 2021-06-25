import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        arr = new int[6];
        for (int i = 0; i < 6; i++) arr[i] = Integer.parseInt(st.nextToken());
        search();
        System.out.println(sb);
    }

    public static void search() {
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (arr[0] * i + arr[1] * j == arr[2]) {
                    if (arr[3] * i + arr[4] * j == arr[5]) {
                        sb.append(i + " " + j);
                        return;
                    }
                }
            }
        }
    }
}
