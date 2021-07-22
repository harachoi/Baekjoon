import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();
        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n.length(); i++) {
            list.add(n.charAt(i) - '0');
            total += n.charAt(i) - '0';
        }

        Collections.sort(list);
        //check if result ends with 0
        if (list.get(0) == 0 && total % 3 == 0) {
            for (int i = list.size() - 1; i >= 0; i--)
                sb.append(list.get(i));
        } else sb.append(-1);

        System.out.println(sb);
    }
}
