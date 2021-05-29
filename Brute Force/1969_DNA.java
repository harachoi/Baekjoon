import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            HashMap<Character, Integer> dup = new HashMap<>();
            int max = 0;
            int maxChar = 'Z';
            for (int j = 0; j < n; j++) {
                dup.put(map[j][i], dup.getOrDefault(map[j][i], 1) + 1);
                if (max < dup.get(map[j][i])) {
                    max = dup.get(map[j][i]);
                    maxChar = map[j][i];
                } else if (max == dup.get(map[j][i])) {
                    if (map[j][i] < maxChar) {
                        max = dup.get(map[j][i]);
                        maxChar = map[j][i];
                    }
                }
            }
            result.append((char) maxChar);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result.charAt(i) != map[j][i]) count++;
            }
        }
        System.out.println(result.append("\n").append(count));
    }
}
