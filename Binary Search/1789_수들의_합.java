import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long addNum = 0;
        while(n >= sum) {
            sum += (++addNum);
        }
        System.out.println(sum == n ? addNum : addNum - 1);
    }
}
