import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //m
    public static LinkedList<Integer>[] arr;
    public static HashSet check;
    public static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(br.readLine());
        int max = 0;
        arr = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            LinkedList<Integer> linkedList = new LinkedList<>();
            if (tmp == 0) {
                arr[i] = linkedList;
                continue;
            }
            if (i - tmp > 0)linkedList.add(i - tmp);
            if (i + tmp <= n) linkedList.add(i + tmp);
            arr[i] = linkedList;
        }
        check = new HashSet();
        for (int i = 0; i < arr[s].size(); i++) max = Math.max(max ,bfs(arr[s].get(i)));

        System.out.println(max == 0 ? 1: max);
    }
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check.add(s);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            check.add(current);
            LinkedList<Integer> list = arr[current];
            for (int i = 0; i < list.size(); i++) {
                if (!check.contains(list.get(i))) queue.add(list.get(i));
            }
        }
        return check.size();
    }
}
