import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String quack = "quack";
        int index = 0;
        int count = 0;
        
        if (sb.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        while (true) {
            StringBuilder tmp = new StringBuilder();
            boolean check = false;
            for (int i = 0; i < sb.length(); i++) {
                if (quack.charAt(index) == sb.charAt(i)) {
                    check = true;
                    index++;
                    if (index == quack.length()) index = 0;
                } else tmp.append(sb.charAt(i));
            }
            if (check && index == 0)  sb = new StringBuilder(tmp);
            else break;
            count++;
        }
        System.out.println(sb.length() == 0 ? count : -1);
    }
}
