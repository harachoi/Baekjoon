import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
        StringBuilder sb = new StringBuilder(br.readLine());
        int total = 0;
        
        for (int i = 0; i < sb.length(); i++) total += map[sb.charAt(i) - 'A'];
        total = total > 10 ? total % 10 : total;
        System.out.println(total % 2 == 0 ? "You're the winner?" : "I'm a winner!");
    }
}
