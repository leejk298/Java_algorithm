import java.util.Scanner;

/*
5 3
1 2 3 1 2
 */

public class 나머지합_백준 {
    static int N, M;    // 크기
    static long[] sum, cnt; // 누적합, 나머지 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 나눌 숫자

        // 초기화
        sum = new long[N + 1];
        cnt = new long[M];

        for(int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + sc.nextInt(); // 누적합
    }

    public static void printPrefixCount() { // 나누어 떨어지는 구간합 출력

        long count = 0; // 개수

        for(int i = 1; i <= N; i++) {   // 크기만큼
            if(sum[i] % M == 0) // 나누어 떨어지면
                count++;    // 개수 카운트

            cnt[(int)(sum[i] % M)]++;   // 나머지 배열에 저장
        }

        for(int i = 0; i < M; i++)  // 나머지 크기만큼
            if(cnt[i] > 1)  // 1개 이상이면 해당 구간합도 나누어 떨어지므로
                count += (cnt[i] * (cnt[i] - 1) / 2);   // 조합으로 개수 카운트

        System.out.println(count);  // 총 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printPrefixCount(); // 나누어 떨어지는 구간합 출력
    }
}
