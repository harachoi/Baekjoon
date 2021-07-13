import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int num; // 숫자
        int idx; // 인덱스

        Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point o) {
            return num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());
            points[i] = new Point(temp, i);
        }
        Arrays.sort(points, 1, N + 1); // 숫자를 기준으로 오름차순 정렬
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, points[i].idx - i);
        }
        System.out.println(max + 1);
    }
}
