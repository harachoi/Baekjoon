import java.io.*;
import java.util.*;

public class Main {
    static int N, maxVal;
    static ArrayList<Character> operator = new ArrayList<>();
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1. 입력 받기
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        //build array
        numbers.add(str.charAt(0) - '0');
        for (int i = 2; i < N; i += 2) {
            operator.add(str.charAt(i - 1));
            numbers.add(str.charAt(i) - '0');
        }

        maxVal = Integer.MIN_VALUE;
        dfs(0, numbers.get(0));

        bw.write(String.valueOf(maxVal));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int sum) {
        if (depth >= operator.size()) {
            maxVal = Math.max(maxVal, sum);
            return;
        }

        //갈로 없을 때
        int partialCal = doCal(sum, numbers.get(depth + 1), depth);
        dfs(depth + 1, partialCal);
        //갈로 있을 때
        if (depth < numbers.size() - 2) {
            partialCal = doCal(numbers.get(depth + 1), numbers.get(depth + 2), depth + 1);
            partialCal = doCal(sum, partialCal, depth);
            dfs(depth + 2, partialCal);
        }
    }


    static int doCal(int a, int b, int opIdx) {
        switch (operator.get(opIdx)) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
        }
        return 0;
    }
}
