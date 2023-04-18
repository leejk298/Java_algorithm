import java.io.*;
import java.util.*;

/**
 5 7 2
 1 3
 2 4
 */
public class 코테복기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // 입력

        long N = sc.nextInt();  // N
        long M = sc.nextInt();  // M
        int K = sc.nextInt();   // 나눌 구간

        long[] x = new long[K + 2]; // 원점 포함 좌표
        long[] y = new long[K + 2];
        for(int i = 1; i <= K; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        x[K + 1] = M;  // (M, N)
        y[K + 1] = N;

        Arrays.sort(x); // 정렬
        Arrays.sort(y);

        long[] ga = new long[K + 1];    // 가로 길이
        long[] se = new long[K + 1];    // 세로 길이
        for(int i = 0; i <= K; i++) {
            ga[i] = x[i + 1] - x[i];
            se[i] = y[i + 1] - y[i];
        }

        long[][] sum = new long[K + 1][K + 1];  // 넓이
        long min = N * M, max = 0;  // 최대, 최소값
        for(int i = 0; i <= K; i++) {
            for(int j = 0; j <= K; j++) {
                sum[i][j] = ga[i] * se[j];

                if(sum[i][j] > max)
                    max = sum[i][j];

                if(sum[i][j] < min)
                    min = sum[i][j];
            }
        }

        System.out.print(min + " " + max);
    }
}