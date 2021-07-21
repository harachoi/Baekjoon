import java.io.*;
import java.util.*;

public class Main {
    static int[] bags;
    static Jewelry[] jewelries;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //가방 오름차순 정렬
        Arrays.sort(bags);
        //보석 무게순 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        //보석 높은 값 기준 힘
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getPrice).reversed());

        int jewelryIdx = 0;
        long total = 0;
        for (int i = 0; i < bags.length; i++) {
            while (jewelryIdx < n && jewelries[jewelryIdx].weight <= bags[i]) {
                pq.add(jewelries[jewelryIdx++]);
            }

            if (!pq.isEmpty()) {
                total += pq.poll().price;
            }
        }

        System.out.println(total);
    }
}

class Jewelry {
    int weight;
    int price;

    public int getWeight() { return weight; }
    public int getPrice() { return price; }

    public Jewelry (int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}
