import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        HashSet<String> list = new HashSet<>();

        for (int cut = 1; cut <= sb.length(); cut++) {
            for (int j = 0; j < sb.length() - cut + 1; j++) {
                list.add(sb.substring(j, j + cut));
            }
        }
        System.out.println(list.size());
    }
}
