import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashMap<Long, Integer> map = new HashMap<>();


        for (int i = 0; i < num; i++) {
            long a = Integer.parseInt(br.readLine());
            boolean isVisit = false;
            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }

                long check = pq.peek() * -1;
                if (map.containsKey(check)) {
                    if (map.get(check) > 0) {
                        map.put(check, map.get(check) - 1);
                        sb.append(check).append("\n");
                        isVisit = true;
                    }
                }
                if (!isVisit) {
                    map.put(pq.peek(), map.get(pq.peek()) - 1);
                    sb.append(pq.peek()).append("\n");
                }
                pq.poll();
            } else {
                pq.add(Math.abs(a));
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        System.out.println(sb);
    }
}
