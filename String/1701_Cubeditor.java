import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder p = new StringBuilder(br.readLine());
        int n = p.length(), max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, getMax(p.substring(i, n)));
        }
        System.out.println(max);
    }

    private static int getMax(String p){
        int j = 0, n = p.length(), max = 0;
        int fail[] = new int[n];
        for(int i = 1; i < n; i++){
            while(j>0 && p.charAt(i) != p.charAt(j)) {
                j = fail[j - 1];
            }
            if(p.charAt(i) == p.charAt(j)) {
                max = Math.max(max, fail[i] = ++j);
            }
        }
        return max;
    }
}
