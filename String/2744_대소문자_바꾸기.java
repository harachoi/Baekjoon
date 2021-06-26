import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (char c : str.toCharArray())
            System.out.print(Character.isUpperCase(c) ? Character.toLowerCase(c): Character.toUpperCase(c));
    }
}
