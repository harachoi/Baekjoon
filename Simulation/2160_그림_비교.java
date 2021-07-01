import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pic = new String[n];
        int min = Integer.MAX_VALUE;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < 5; j++) str += br.readLine();
            pic[i] = str;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < pic[j].length(); k++) {
                    if (pic[i].charAt(k) != pic[j].charAt(k)) count++;
                }
                if (count < min) {
                    min = count;
                    a = i + 1;
                    b = j + 1;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
