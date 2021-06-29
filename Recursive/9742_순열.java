import java.io.IOException;
import java.util.*;

public class Main {

    private static int index = 0;
    private static String result = "No permutation";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.next();
            int count = sc.nextInt();

            int n = s.length();
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            char[] ouput = new char[n];

            permutation(s.toCharArray(), ouput, visited, 0, n, n, count);

            System.out.println(s + " " + count + " = " + result);
            result = "No permutation";
            index = 0;
        }
    }


    public static void permutation(char[] charArr, char[] output, boolean[] visited, int depth,
                                   int n, int r, int count) {
        if (depth == r) {
            index++;
            if (index == count) {
                result = new String(output);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[depth] = charArr[i];
                permutation(charArr, output, visited, depth + 1, n, r, count);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }
}
