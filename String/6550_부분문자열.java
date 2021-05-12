import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null) {
            String[] str = s.split(" ");
            int index = 0;
            
            for (int i = 0; i < str[1].length(); i++) {
                if (str[1].charAt(i) == str[0].charAt(index)) {
                    index++;
                    if (index == str[0].length()) break;
                }
            }
            sb.append(index == str[0].length() ? "Yes\n" : "No\n");
        }
        System.out.println(sb);
    }
}
