import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String k = br.readLine();
        String cleaned = "";
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                cleaned += s.charAt(i);
            }
        }
        System.out.println(cleaned.contains(k) ? 1 : 0);
    }
}
