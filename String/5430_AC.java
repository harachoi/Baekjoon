import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> deque = new ArrayDeque<Integer>();
            for (int j = 0; j < n; j++)  deque.add(Integer.parseInt(st.nextToken()));

            boolean check = false;
            boolean reverse = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') { //equal 'R'
                    reverse = !reverse;
                    continue;
                }

                //equal 'D'
                if (reverse) {
                    if (deque.pollLast() == null) {
                        check = true;
                        break;
                    }
                } else {
                    if (deque.pollFirst() == null) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) result.append("error\n");
            else {
                result.append("[");
                if (deque.size() > 0) {
                    if (reverse) {
                        result.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            result.append(",").append(deque.pollLast());
                        }
                    } else {
                        result.append(deque.pollFirst());
                        while (!deque.isEmpty()) {
                            result.append(",").append(deque.pollFirst());

                        }
                    }
                }
                result.append("]\n");
            }
        }
        System.out.println(result);
    }
}
