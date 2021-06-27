import java.io.*;
import java.util.*;

public class Main {
    static int x, y, px, py;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        px = Integer.parseInt(st.nextToken());
        py = Integer.parseInt(st.nextToken());
        check = new int[10000205];

        System.out.println(find_LCM(px, py));
    }

    public static int find_LCM(int num1, int num2) {
        for(int i = 0; i <= 100000; i++){
            check[num1 + (x*i)] = 1;
        }
        for(int i = 0; i <= 100000; i++){
            if(check[num2 + (y*i)] == 1){
                return num2 + (y*i);
            }
        }
        return -1;
    }
}
