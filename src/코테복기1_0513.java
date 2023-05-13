import java.util.*;

public class 코테복기1_0513 {
    static int N;   // 크기
    static long M;  // 경계값
    static long[] P;    // 페어쌍배열

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextLong();

        // 초기화
        P = new long[N];
        for(int i = 0; i < N; i++)
            P[i] = sc.nextLong();
    }

    public static int countPair() { // 페어쌍 개수
        int count = 0;  // 개수
        long sum = 0;   // 경계값

        for(int i = 0; i < N / 2; i++) {    // 절반만, 홀수이면 가운데 생략
            sum = P[i] + P[N - 1 - i];  // 합

            if(sum >= M)    // 크면
                count++;    // 카운트 세기
        }

        return count;   // 개수 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(countPair());    // 페어쌍 개수 출력
    }
}
