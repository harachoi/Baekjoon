import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hashSet = new HashSet<>();
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            hashSet.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(hashSet);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String v1, String v2) {
                if(v1.length() > v2.length())
                    return 1;
                else if(v1.length() < v2.length())
                    return -1;
                else
                    return v1.compareTo(v2);
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
