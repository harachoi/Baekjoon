import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        int target = (int)(y*100/x);
        int first=0,last=1000000001,mid=0;
        int temp;

        if (target >= 99) {
            System.out.println(-1);
        } else {
            while(first <= last) {
                mid = (first+last)/2;
                temp = (int) ((y+mid)*100/(x+mid));
                if (temp > target) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
            System.out.println(first);
        }
    }
}
