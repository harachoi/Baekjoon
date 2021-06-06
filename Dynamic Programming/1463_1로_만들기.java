import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int n = Integer.parseInt(br.readLine());
		System.out.println(recur(n, 0));
	}
 
	static int recur(int n, int count) {
		if (n < 2) {
			return count;
		}
		return Math.min(recur(n / 2, count + 1 + (n % 2)), recur(n / 3, count + 1 + (n % 3)));
 
	}
}
