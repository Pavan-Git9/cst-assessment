import java.util.*;

public class DifferencePair {
    public static String findDifferencePair(int[] arr, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num + k) || seen.contains(num - k)) {
                return "YES";
            }
            seen.add(num);
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(findDifferencePair(arr, k));
    }
}