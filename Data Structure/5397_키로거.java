import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < l; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            Stack<Character> preStack = new Stack<>();
            Stack<Character> postStack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    if (!preStack.isEmpty()) postStack.push(preStack.pop());
                }
                else if (str.charAt(j) == '>') {
                    if (!postStack.isEmpty()) preStack.push(postStack.pop());
                }
                else if (str.charAt(j) == '-') {
                    if (!preStack.isEmpty()) preStack.pop();
                }
                else {
                    preStack.push(str.charAt(j));
                }
            }
            while (!preStack.isEmpty()) postStack.push(preStack.pop());
            while (!postStack.isEmpty()) sb.append(postStack.pop());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
