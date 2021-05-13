import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        boolean java = sb.toString().contains("_") ? true : false;
        boolean flag = false;
        boolean capi = false;

        if (sb.length() == 0) flag = true;
        for (int i = 0; i < sb.length(); i++) {
            if (java && Character.isUpperCase(sb.charAt(i)) || !java && sb.charAt(i) == '_') {
                flag = true;
                break;
            }
            if (java) {
                if (sb.charAt(0) == '_' || sb.charAt(sb.length() - 1) == '_') {
                    flag = true;
                    break;
                }
                if (sb.charAt(i) == '_') {
                    capi = true;
                    if (i < sb.length() - 1) {
                        if (sb.charAt(i + 1) == '_') {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    if (capi) sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                    capi = false;
                }
            } else if (!java) {
                if (Character.isUpperCase(sb.charAt(0))) {
                    flag = true;
                    break;
                }
                if (Character.isUpperCase(sb.charAt(i))) {
                    String tmp = "";
                    if (i + 1 < sb.length()) tmp = sb.substring(i+1);
                    sb = new StringBuilder(sb.substring(0, i) + "_" + Character.toLowerCase(sb.charAt(i)) + tmp);
                }
            }
        }
        if (java) sb = new StringBuilder(sb.toString().replaceAll("_", ""));
        System.out.println(flag ? "Error!" : sb);
    }
}
