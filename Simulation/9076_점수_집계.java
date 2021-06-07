import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int j = 0; j < arr.length; j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if (arr[3] - arr[1] >= 4) sb.append("KIN").append("\n");
            else {
                int total = 0;
                for (int j = 1; j < 4; j++) total += arr[j];
                sb.append(total).append("\n");
            }
        }
        System.out.println(sb);
    }
}
