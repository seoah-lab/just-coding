import java.util.Arrays;
import java.util.Scanner;

public class SearchExcludeIndex {

    static int searchIdx(int[] a, int n, int key, int[] idx) {

        int notMatch = 0;
        for (int i = 0; i < n; i++) {
            if (key == a[i]) {
                notMatch++;
            }
        }

        idx = new int[notMatch];
        notMatch = 0;
        for (int i = 0; i < n; i++) {
            if (key == a[i]) {
                idx[notMatch] = i;
                notMatch++;
            }
        }
        System.out.println(Arrays.toString(idx));
        return idx.length;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요소의 수:");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.print("찾는 값："); // 키 값을 입력 받음
        int key = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            a[i] = scanner.nextInt();
        }

        int[] idx = new int[0];

        System.out.println(searchIdx(a, n, key, idx));

    }
}
