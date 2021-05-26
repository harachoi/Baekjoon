import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        boolean check = false;
        int bracket = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '<') {
                bracket = i;
                check = true;
                if (tmp.length() != 0) {
                    result.append(tmp.reverse());
                    tmp = new StringBuilder();
                }
            } else if (sb.charAt(i) == '>') {
                result.append(sb.substring(bracket, i + 1));
                check = false;
            } else if (!check && sb.charAt(i) != ' ') {
                tmp.append(sb.charAt(i));
            } else if (!check && sb.charAt(i) == ' ') {
                result.append(tmp.reverse()).append(" ");
                tmp = new StringBuilder();
            }
        }
        if (tmp.length() != 0) {
            result.append(tmp.reverse());
        }
        System.out.println(result);
    }
}
