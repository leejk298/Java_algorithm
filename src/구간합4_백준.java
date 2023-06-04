import java.util.*;

/*
5 3
5 4 3 2 1
1 3
2 4
5 5
 */

public class 구간합4_백준 {
    static int N, M;    // 크기
    static int[] sum, x, y; // 누적합, 구간

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();

        // 초기화
        sum = new int[N + 1];
        for(int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + sc.nextInt();

        x = new int[M];
        y = new int[M];
        for(int i = 0; i < M; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
    }

    public static void printSum() { // 구간합 출력

        for(int i = 0; i < M; i++) {    // 크기만큼
            int s = x[i], e = y[i]; // 시작, 끝

            System.out.println(sum[e] - sum[s - 1]);    // 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printSum(); // 구간합 출력
    }
}
