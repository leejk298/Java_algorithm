import java.util.*;

/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */

public class 동전0_백준 {
    static int N, K;    // 크기
    static int[] coin;  // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        K = sc.nextInt();   // 합

        // 초기화
        coin = new int[N];
        for (int i = 0; i < N; i++)
            coin[i] = sc.nextInt();
    }

    public static void printMinCount() {    // 최소 동전 개수 출력

        int count = 0;  // 개수
        for (int i = N - 1; i >= 0; i--) {  // 큰 수부터
            if (K / coin[i] > 0) {  // 나눠지면
                count += (K / coin[i]); // 개수 카운터
                K %= coin[i];   // 합 갱신
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinCount();    // 최소 동전 개수 출력
    }
}
