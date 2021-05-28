import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] list = new int[9];
        int sum = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (sum - list[i] - list[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        
        for (int i = 0; i < list.length; i++) {
            if (i != a && i != b) {
                sb.append(list[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
