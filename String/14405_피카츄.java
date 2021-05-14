import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("pi", " ");
        str = str.replaceAll("ka", " ");
        str = str.replaceAll("chu", " ");
        str = str.replaceAll(" ", "");
        System.out.println(str.length() == 0 ? "YES" : "NO");
    }
}
