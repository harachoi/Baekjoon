import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1. 입력 받기
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < num) list.add(num);
            else binSearch(num);
        }

        bw.write(String.valueOf(list.size() - 1));

        bw.flush();
        bw.close();
        br.close();
    }
    public static void binSearch(int in) {
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
