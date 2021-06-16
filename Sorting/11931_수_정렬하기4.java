import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(br.readLine()));
        Iterator itr = set.descendingIterator();
        while (itr.hasNext())  sb.append(itr.next()).append("\n");
        System.out.println(sb);
    }
}
