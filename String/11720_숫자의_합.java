import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int total = 0;
        for (int i = 0; i < num; i++) {
            total += str.charAt(i) - '0';
        }
        System.out.println(total);
    }
}
