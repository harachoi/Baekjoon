import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o1[1]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        queue.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() <= arr[i][0]) queue.poll();
            queue.add(arr[i][1]);
        }
        System.out.println(queue.size());
    }
}
