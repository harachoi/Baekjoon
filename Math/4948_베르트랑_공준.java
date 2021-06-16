import java.io.*;

class Main {
    public static boolean[] prime;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sieveOfEratosthenes();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            int count = 0;
            for (int i = num + 1; i <= num * 2; i++) {
                if (prime[i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void sieveOfEratosthenes() {
        prime = new boolean[123456*2 + 1];
        for(int i=0;i<prime.length;i++) prime[i] = true;

        for(int p = 2; p*p <prime.length; p++) {
            if(prime[p] == true) {
                for(int i = p*p; i <prime.length; i += p) prime[i] = false;
            }
        }
    }
}
