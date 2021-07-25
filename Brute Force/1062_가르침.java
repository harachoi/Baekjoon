package DAY01.C1062;
/**
 * 백준 - 가르침
 */

import java.io.*;
import java.util.*;
public class Main {
    static HashSet<Character> learn;
    static String[] words;
    static int[] arr;
    static boolean[] visit = new boolean[26];
    static int max = 0, n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == 0 || k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            words[i] = str.substring(4, str.length() - 4);
        }

        visit['a' - 'a'] = true;
        visit['c' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['n' - 'a'] = true;

        //user combination to find cases that can be made with left over characters
        arr = new int[k - 5];
        permutation(0, 0);

        System.out.println(max);
    }

    public static void permutation(int at, int depth) {
        if (at == k - 5) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                boolean isValid = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visit[words[i].charAt(j) - 'a']) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) count++;
            }
            max = Math.max(max, count);
            return;
        }

        //permutation
        for (int i = depth; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(at + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
