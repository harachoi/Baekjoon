import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            StringBuilder sb = new StringBuilder(br.readLine());
            if (sb.toString().equals("END")) break;
            result.append(sb.reverse()).append("\n");
        }
        System.out.println(result);
    }
}
