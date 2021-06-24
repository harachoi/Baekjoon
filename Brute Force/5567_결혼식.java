import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count;
    static boolean[] isVisit;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        isVisit = new boolean[n + 1];
        count = 0;
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        isVisit[1] = true;
        for (int i = 0; i < list[1].size(); i++) {
            search(list[1].get(i));
        }
        System.out.println(count);
    }

    public static void search(int index) {
        if (!isVisit[index]) {
            count++;
            isVisit[index] = true;
        }
        for (int i = 0; i < list[index].size(); i++) {
            if (!isVisit[list[index].get(i)]) {
                count++;
                isVisit[list[index].get(i)] = true;
            }
        }
    }
}
