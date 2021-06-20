import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Pair> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) list.add(new Pair(i, Integer.parseInt(st.nextToken())));
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                // TODO Auto-generated method stub

                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value > o2.value) {
                    return 1;
                } else {
                    if (o1.idx < o2.idx) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for (int i = 0; i < n; i++) arr[list.get(i).idx] = i;
        for (int i = 0; i < n; i++) sb.append(arr[i] + " ");
        System.out.println(sb);
    }

    public static class Pair {
        int idx;
        int value;

        Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
