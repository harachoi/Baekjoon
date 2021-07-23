import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        sieveOfEratosthenes(1000000);

        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            search(n);
        }
        System.out.print(sb);
    }

    public static void search(int n) {
        int idx = 2;
        while (idx < n) {
            if (prime[idx]) {
                if (prime[n - idx]) {
                    sb.append(n + " = " + idx + " + " + (n - idx)).append("\n");
                    return;
                }
            }
            idx++;
        }
        sb.append("Goldbach's conjecture is wrong.").append("\n");
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
