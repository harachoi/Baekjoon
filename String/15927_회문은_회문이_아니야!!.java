import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder given = new StringBuilder(br.readLine());
        boolean check = false;
        char first = given.charAt(0);
        for (int i = 1; i < given.length(); i++) {
            if (given.charAt(i) != first) check = true;
        }
        if (!check) {
            System.out.println(-1);
            return;
        }
        int start = 0;
        int end = given.length() - 1;
        check = false;
        while (start < end) {
            if (given.charAt(start) == given.charAt(end)) {
                start++;
                end--;
            } else {
                check = true;
                break;
            }
        }
        if (check) System.out.println(given.length());
        else System.out.println(given.length() - 1);
    }
}
