import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        String str = sb.toString().replaceAll("c=", "1");
        str = str.replaceAll("c-", "1");
        str = str.replaceAll("dz=", "1");
        str = str.replaceAll("dz=","1");
        str = str.replaceAll("d-", "1");
        str = str.replaceAll("lj", "1");
        str = str.replaceAll("nj", "1");
        str = str.replaceAll("s=", "1");
        str = str.replaceAll("z=", "1");

        System.out.println(str.length());
    }
}
