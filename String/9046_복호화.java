import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] count = new int[26];
            boolean check = false;
            int index = -1;
            int max = 0;
            str = str.replaceAll(" ", "");
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
                max = Math.max(count[str.charAt(j) - 'a'], max);
            }
            for (int j = 0; j < count.length; j++) {
                if (max == count[j]) {
                    if (index != -1) check = true;
                    index = j;
                }
            }
            sb.append(check ? "?" : (char) (index + 'a')).append("\n");
        }
        System.out.println(sb);
    }
}
