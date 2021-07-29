import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1. 입력 저장하기
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        //2. 입력 받으며 이분탐색 사용해 정렬하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(0);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                binaryInsert(num);
            }
        }

        bw.write(String.valueOf(list.size() - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    static void binaryInsert(int in) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= in) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        list.set(right, in);
    }
}
