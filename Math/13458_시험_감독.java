import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //1.입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //2. 최소 감독관 구하기
        long total = N; //최소 1명의 총감독관이 시험장에 있다
        for (int i = 0; i < N; i++) {
            if (arr[i] <= B) continue;

            //부감독관
            arr[i] -= B;
            total += arr[i] / C;
            if (arr[i] % C != 0) total++;
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();
    }
}
