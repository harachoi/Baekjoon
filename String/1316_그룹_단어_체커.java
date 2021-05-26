import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        boolean no = false;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set = new HashSet<>();
            set.add(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j - 1) != word.charAt(j)) {
                    if (set.contains(word.charAt(j))) {
                        no = true;
                        break;
                    }
                    else {
                        set.add(word.charAt(j));
                    }
                }
            }
            if (!no) {
                count++;
            }
            no = false;
        }
        System.out.println(count);
    }
}
