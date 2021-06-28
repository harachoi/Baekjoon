import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        int[] tmp = new int[3];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = 1;
        }

        while (true) {
            if (tmp[0] == 16) tmp[0] = 1;
            if (tmp[1] == 29) tmp[1] = 1;
            if (tmp[2] == 20) tmp[2] = 1;

            if (tmp[0] == arr[0]) {
                if (tmp[1] == arr[1]) {
                    if (tmp[2] == arr[2]) {
                        System.out.println(count);
                        return;
                    }
                }
            }
            tmp[0]++;
            tmp[1]++;
            tmp[2]++;
            count++;
        }
    }
}
