import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char before = '0';
        int sum = 1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'd') { // d
                if (before == input.charAt(i)) {
                    sum /= 10;
                    sum *= (10*10) - 10; 
                } else sum *= 10;
            } else { //c
                if (before == input.charAt(i)) {
                    sum /= 26;
                    sum *= (26 * 26) - 26;
                } else sum *= 26;
            }
            before = input.charAt(i);
        }
        System.out.println(sum);
    }
}
