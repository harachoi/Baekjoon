  
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken()), tmp, coin = 0;
        long limit = Integer.parseInt(br.readLine());
        boolean max = false;
        for (int i = 1; i < n; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (!max && limit > tmp) limit = tmp;
            else if (!max && limit < tmp) {
                coin = w / limit;
                w = w % limit;
                limit = tmp;
                max = true;
            } else if (max && limit < tmp) limit = tmp;
            else if (max && limit > tmp) {
                w = coin * limit + w;
                limit = tmp;
                coin = 0;
                max = false;
            }
        }
        if (coin != 0) w = coin * limit + w;
        System.out.println(w);
    }
}
