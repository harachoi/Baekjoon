import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' ') {
                if (str.charAt(i) > 'Z') {
                    result.append(str.charAt(i) + 13 > 'z' ? (char) ('a' + (str.charAt(i) + 13 - 'z' - 1)) : (char) (str.charAt(i) + 13));
                } else {
                    result.append(str.charAt(i) + 13 > 'Z' ? (char) ('A' + (str.charAt(i) + 13 - 'Z' - 1)) : (char) (str.charAt(i) + 13));
                }
            } else {
                result.append(str.charAt(i));
            }
        }
        System.out.println(result);
    }
}
