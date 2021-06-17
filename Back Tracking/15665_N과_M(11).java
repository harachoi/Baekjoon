import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums, perm;
    static boolean[] visit;
    static LinkedHashSet<String> ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        perm = new int[M];
        visit = new boolean[N];
        ans = new LinkedHashSet<>();
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        permutation(0);
        ans.forEach(System.out::println);
    }

    public static void permutation(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int val : perm) {
                sb.append(val).append(' ');
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            perm[depth] = nums[i];
            permutation(depth + 1);
        }
    }
}
