import java.io.*;
import java.util.*;

public class Main {
    static int[] leftToRight, rightToLeft;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        leftToRight = new int[n];
        rightToLeft = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        //build left to right
        leftToRight[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftToRight[i] = gcd(leftToRight[i - 1], arr[i]);

        //build right to left
        rightToLeft[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightToLeft[i] = gcd(rightToLeft[i + 1], arr[i]);

        //search
        long maxGcd = 0;
        int removeIdx = 0;
        for (int i = 0; i < n; i++) {
            long result = 0;
            //no left
            if (i == 0) 
                result = rightToLeft[1];
            //no right
            else if (i == n - 1)
                result = leftToRight[n - 2];
            //left & right exist
            else 
                result = gcd(leftToRight[i - 1] , rightToLeft[i + 1]);
            
            if (arr[i] % result != 0 && result > maxGcd) {
                maxGcd = result;
                removeIdx = i;
            }
        }
        System.out.println(maxGcd == 0 ? -1 : maxGcd + " " + arr[removeIdx]);
    }

    //gcd(a,b) == gcd(b a % b), stop when a%b == 0
    static int gcd(int a, int b) {
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
