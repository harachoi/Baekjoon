import java.io.*;
import java.util.*;

class Main {
    public static boolean[] prime;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n + 1];
        sieveOfEratosthenes(n);
        int count = 0;
        boolean isVisit = false;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i; j <= n; j+=i) {
                    if (!check[j]) {
                        check[j] = true;
                        count++;
                    }
                    if (count == k) {
                        isVisit = true;
                        System.out.println(j);
                        break;
                    }
                }
            }
            if (isVisit) break;
        }
    }

    public static void sieveOfEratosthenes(int n) {
        prime = new boolean[n + 1];
        for(int i=0;i<prime.length;i++) prime[i] = true;

        for(int p = 2; p*p <prime.length; p++) {
            if(prime[p] == true) {
                for(int i = p*p; i <prime.length; i += p) prime[i] = false;
            }
        }
    }
}
