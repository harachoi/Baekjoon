import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nArr = new long[n];
        for (int i = 0; i < n; i++) nArr[i] = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        long[] mArr = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) mArr[i] = Long.parseLong(st.nextToken());

        //build n cases
        ArrayList<Long> nCase = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = nArr[i];
            nCase.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += nArr[j];
                nCase.add(sum);
            }
        }

        //build m cases
        ArrayList<Long> mCase = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += mArr[j];
                mCase.add(sum);
            }
        }

        Collections.sort(nCase);
        Collections.sort(mCase, Collections.reverseOrder());

        //find cases
        long count = 0;
        int nPoint = 0;
        int mPoint = 0;

        while (mPoint < mCase.size() && nPoint < nCase.size()) {
            long currentA = nCase.get(nPoint);
            long target = T - currentA;
            if (mCase.get(mPoint) > target) {
                mPoint++;
            } else if (mCase.get(mPoint) == target) {
                long countN = 0;
                long countM = 0;
                while (nPoint < nCase.size() && nCase.get(nPoint) == currentA) {
                    nPoint++;
                    countN++;
                }
                while (mPoint < mCase.size() && mCase.get(mPoint) == target) {
                    mPoint++;
                    countM++;
                }
                count += countN * countM;
            } else {
                nPoint++;
            }
        }
        System.out.println(count);
    }
}
