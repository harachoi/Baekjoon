import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        HashSet<Character> check = new HashSet<>();
        check.add('a'); check.add('e'); check.add('i'); check.add('o'); check.add('u');

        while (!str.equals("end")) {
            boolean checkOne = false;
            boolean pass = true;
            char before = '0';
            int count = 0;
            int checkTwo = 0;
            boolean in = false;
            for (int i = 0; i < str.length(); i++) {
                if (!checkOne && check.contains(str.charAt(i))) checkOne = true; //check one
                
                if (check.contains(str.charAt(i))) { //check 2
                    if (in) checkTwo = 0;
                    checkTwo++;
                    in = false;
                } else {
                    if (!in) checkTwo = 0;
                    checkTwo++;
                    in = true;
                }
                if (checkTwo == 3) pass = false;

                if (before != str.charAt(i)) { //check 3
                    count = 0;
                    before = str.charAt(i);
                    count++;
                } else if (before == str.charAt(i)) {
                    count++;
                }
                if (count == 2  && before != 'e' && before != 'o') {
                    pass = false;
                }
            }

            sb.append("<" + str +">");
            if (checkOne && pass) sb.append(" is acceptable.\n");
            else sb.append(" is not acceptable.\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
