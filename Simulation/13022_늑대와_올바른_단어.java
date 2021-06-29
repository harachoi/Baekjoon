import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] wolf = new char[]{'w', 'o', 'l', 'f'};
        int wolfIdx = 0;
        int pre = 0;
        int post = 0;
        int result = 1;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == wolf[wolfIdx]) {
                post++;
                i++;
            }
            else {
                if (wolfIdx == 0) pre = post;
                else if (post != pre) {
                        result = 0;
                        break;
                }
                wolfIdx++;
                if (wolfIdx == 4) wolfIdx = 0;
                post = 0;
            }
        }
        if (wolfIdx != 3 || pre != post) result = 0;
        System.out.println(result);
    }
}
