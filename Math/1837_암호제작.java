import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        String P=(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[K];//k-1까지라고 범위를 잡아주었으므로
        isPrime[0]=true;isPrime[1]=true;
        for(int i =0; i<isPrime.length;i++) {
            if(!isPrime[i]) {//어떤 하나의 수가 소수이면 그 수의 배수부터는 합성수임을 이용한 체
                for(int j =2*i; j<isPrime.length;j=j+i) {
                    isPrime[j]=true;
                }
            }
        }


        for(int k = 0; k<isPrime.length;k++) {
            if(!isPrime[k]) {
                int remain = 0;
                for(int i = 0; i<P.length();i++) {
                    remain = (remain * 10 + P.charAt(i) - '0') % k;
                }

                if(remain == 0) {
                    System.out.println("BAD "+ k);
                    return;
                }
            }
        }
        System.out.println("GOOD");
    }
}
