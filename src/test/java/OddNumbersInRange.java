import java.util.*;

public class OddNumbersInRange {
    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (i % 2 != 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        List<Integer> odds = oddNumbers(l, r);
        for (int num : odds) {
            System.out.print(num + " ");
        }
    }
}