import java.util.*;
import java.io.*;

public class 전광판_소프티어 {
    static Map<Integer, int[]> num;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        num = new HashMap<>();
        num.put(0, new int[] {1, 1, 1, 1, 1, 1, 0});
        num.put(1, new int[] {0, 1, 1, 0, 0, 0, 0});
        num.put(2, new int[] {1, 1, 0, 1, 1, 0, 1});
        num.put(3, new int[] {1, 1, 1, 1, 0, 0, 1});
        num.put(4, new int[] {0, 1, 1, 0, 0, 1, 1});
        num.put(5, new int[] {1, 0, 1, 1, 0, 1, 1});
        num.put(6, new int[] {1, 0, 1, 1, 1, 1, 1});
        num.put(7, new int[] {1, 1, 1, 0, 0, 1, 0});
        num.put(8, new int[] {1, 1, 1, 1, 1, 1, 1});
        num.put(9, new int[] {1, 1, 1, 1, 0, 1, 1});

        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int arrA[] = new int[5];
            int arrB[] = new int[5];

            Arrays.fill(arrA, -1);
            Arrays.fill(arrB, -1);

            int j = 0;
            while(A != 0) {
                arrA[j++] = A % 10;
                A /= 10;
            }

            j = 0;
            while(B != 0) {
                arrB[j++] = B % 10;
                B /= 10;
            }

            int res = 0;
            for(int k = 0; k < 5; k++) {
                if(arrA[k] != arrB[k]) {
                    if(arrA[k] == -1)
                        res += sum(arrB[k]);
                    else if(arrB[k] == -1)
                        res += sum(arrA[k]);
                    else
                        res += dif(arrA[k], arrB[k]);
                }
            }

            System.out.println(res);
        }
    }

    static int dif(int A, int B) {
        int arrA[] = num.get(A);
        int arrB[] = num.get(B);

        int count = 0;
        for(int i = 0; i < 7; i++)
            if(arrA[i] != arrB[i])
                count++;

        return count;
    }

    static int sum(int S) {
        int tmp[] = num.get(S);

        int count = 0;
        for(int i = 0; i < 7; i++)
            count += tmp[i];

        return count;
    }
}