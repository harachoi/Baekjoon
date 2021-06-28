import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] scores = new String[n][4];

        for (int i = 0; i < n; i++) scores[i] = br.readLine().split(" ");

        Arrays.sort(scores, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                        if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                            return o1[0].compareTo(o2[0]);
                        }
                        //내림차순
                        return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
                    }
                    //오름차순
                    return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
                }
                return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
            }
        });

        for (int i = 0; i < n; i++) sb.append(scores[i][0]).append("\n");
        System.out.println(sb);
    }
}
