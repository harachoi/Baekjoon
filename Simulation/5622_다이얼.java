import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= 'C') total += 2;
            else if (str.charAt(i) <= 'F') total += 3;
            else if (str.charAt(i) <= 'I') total += 4;
            else if (str.charAt(i) <= 'L') total += 5;
            else if (str.charAt(i) <= 'O') total += 6;
            else if (str.charAt(i) <= 'S') total += 7;
            else if (str.charAt(i) <= 'V') total += 8;
            else if (str.charAt(i) <= 'Z') total += 9;
        }
        System.out.println(total + str.length());
    }
}
