import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] arr = new int[10];
        for (int i = 0; i < n.length(); i++) arr[n.charAt(i) - '0']++;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            }
        }
        System.out.println(Math.max(max, (arr[6] + arr[9] + 1) / 2));
    }
}
