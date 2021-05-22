import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (n - i > j) bw.write(" ");
                else bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
