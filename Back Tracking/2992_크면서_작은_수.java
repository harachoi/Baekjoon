import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> list;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        String num = br.readLine();
        n = Integer.parseInt(num);
        int min = Integer.MAX_VALUE;
      
        //permutation
        permute(num, 0, num.length() - 1);
        
        //Search for min value
        for (int i = 0; i < list.size(); i++)  min = Math.min(min, list.get(i));
        System.out.println(list.size() == 0 ? 0 :  min);
    }

    public static void permute(String str, int l, int r)
    {
        if (l == r) {
            int tmp = Integer.parseInt(str);
            if (tmp > n)
                list.add(Integer.parseInt(str));
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
