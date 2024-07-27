import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int target = scanner.nextInt();
        scanner.close();

        Collections.sort(list);

        int p1 = 0;
        int p2 = n-1;
        int count = 0;
        while (true) {
            if (p1 >= p2) break;

            int n1 = list.get(p1);
            int n2 = list.get(p2);
            if (n1+n2 > target) {
                p2--;
                continue;
            }
            if (n1+n2 < target) {
                p1++;
                continue;
            }

            p1++;
            p2--;
            count++;
        }

        System.out.println(count);
    }
}
