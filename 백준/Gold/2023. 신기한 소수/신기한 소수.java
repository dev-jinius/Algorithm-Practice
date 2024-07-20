import java.util.*;

public class Main {
    static List<Integer> result = new ArrayList<>();

    private static void find(int n, int target, int index) {
        if (index == n) {
            result.add(target);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int candidate = target * 10 + i;
            if (isPrime(candidate)) {
                find(n, candidate, index+1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        find(n, 2, 1);
        find(n, 3, 1);
        find(n, 5, 1);
        find(n, 7, 1);

        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
