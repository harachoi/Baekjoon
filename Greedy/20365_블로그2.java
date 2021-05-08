import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int red = 0, blue = 0;
        boolean bluecolor = false;
        if (line.charAt(0) == 'B') {
            bluecolor = true;
            blue++;
        } else red++;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'B' && !bluecolor) {
                blue++;
                bluecolor = true;
            }
            else if (line.charAt(i) == 'R' && bluecolor) {
                red++;
                bluecolor = false;
            }
        }
        if (red == 0 || blue == 0) System.out.println(1);
        else if (red == 1 && blue == 1) System.out.println(1);
        else System.out.println(blue < red ? blue + 1 : red + 1);
    }
}
