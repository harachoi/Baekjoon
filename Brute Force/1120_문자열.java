import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int diff = b.length() - a.length();
        int min = 10000;
        int tmp = 0;

        for (int i = 0; i < diff + 1; i ++) {
            tmp = 0;
            for (int j = 0; j < a.length(); j++) {
               if (a.charAt(j) != b.charAt(j + i)) {
                   tmp++;
               }
            }
            if (tmp < min) {
                min = tmp;
            }
        }

        System.out.println(min);
    }
}
