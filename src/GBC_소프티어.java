import java.util.*;
import java.io.*;


public class GBC_소프티어 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int l1[] = new int[N];
        int v1[] = new int[N];

        int l2[] = new int[M];
        int v2[] = new int[M];

        l1[0] = sc.nextInt();
        v1[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            l1[i] = l1[i - 1] + sc.nextInt();
            v1[i] = sc.nextInt();
        }

        l2[0] = sc.nextInt();
        v2[0] = sc.nextInt();
        for (int j = 1; j < M; j++) {
            l2[j] = l2[j - 1] + sc.nextInt();
            v2[j] = sc.nextInt();
        }

        int i = 0, j = 0;
        int max = 0;
        while (i != N || j != M) {
            if (v2[j] - v1[i] > max) {
                max = v2[j] - v1[i];
            }

            if (l1[i] < l2[j]) {
                i++;
            } else if (l1[i] > l2[j]) {
                j++;
            } else {
                i++;
                j++;
            }
        }

        System.out.println(max);
    }
}