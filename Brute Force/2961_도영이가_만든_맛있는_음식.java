import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static int limit, n;
    static int[] sour, bitter, nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];
        nums = new int[n];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        for (int j = 1; j <= n; j++) {
            limit = j;
            combination(0, 0);
        }
        System.out.println(min);
    }

    /** n개 중 i개를 고르는 조합 */
    private static void combination(int cnt, int index) {

        if (limit == cnt) {
            int sum = 0;
            int mul = 1;
            for (int i = 0; i < limit; i++) {
                mul *= sour[nums[i]];
                sum += bitter[nums[i]];
            }
            min = Math.min(min, Math.abs(sum - mul));
            return;
        }

        for (int i = index; i < n; i++) {
            nums[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
}
