import java.util.*;

/*
5 3
0 1 0 0 1
 */

public class 복습3번_2 {   // 성능 최적화 방법
    static int N, M;    // 크기
    static int[] sumArr;    // 누적합배열
    static int[] S, T;  // 구간배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 구간 개수

        // 초기화
        sumArr = new int[N + 1];
        for(int i = 1; i <= N; i++) // 1 부터, 인덱스 0의 값은 0
            sumArr[i] = sumArr[i - 1] + sc.nextInt();   // 누적합배열

        // 초기화
        S = new int[M];
        T = new int[M];
        for(int i = 0; i < M; i++) {
            S[i] = sc.nextInt();    // 시작
            T[i] = sc.nextInt();    // 끝
        }
    }

    public static long countSum() { // 총 합 개수 출력

        long sum = 0;   // 합

        for(int i = 0; i < M; i++) {    // 크기만큼
            int s = S[i], t = T[i]; // 구간

            sum += sumArr[t] - sumArr[s - 1];   // 구간합
        }

        return sum; // 총 합 출력
    }

    public static void main(String[] args) {

        init(); // 초기화, O(N) + O(M)

        System.out.println(countSum()); // 합 출력, O(M), 인덱스로 바로 접근하므로
    }
}