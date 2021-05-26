import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list);
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        ArrayList<String> answerList = new ArrayList<String>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int index = Arrays.binarySearch(arr, str);
            if (index >= 0) {
                answerList.add(str);
            }
        }
        Collections.sort(answerList);
        sb.append(answerList.size() + "\n");
        for(String s : answerList) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
