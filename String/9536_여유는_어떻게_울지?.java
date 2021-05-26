import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        HashMap<String,String> animal=new HashMap();
        int testCase=input.nextInt();
        input.nextLine();
        for(int i=0;i<testCase;i++) {
            boolean run=true;
            String str=input.nextLine();
            String[] woolTokens=str.split(" ");//¿ïÀ½¼Ò¸® ÅäÅ«
            while(run) {
                String word=input.nextLine();
                String[] wordTokens=word.split(" ");
                if(!wordTokens[1].equals("goes")) {
                    run=false;
                }else {
                    animal.put(wordTokens[0], wordTokens[2]);
                }
            }
            for(int j=0;j<woolTokens.length;j++) {
                if(!animal.containsValue(woolTokens[j])) {
                    System.out.print(woolTokens[j]+" ");
                }
            }System.out.println();
        }
    }
}
