import java.util.*;

/*
10 2
3 -2 -4 -9 0 3 7 13 8 -3
 */
public class 수열_백준 {
    static int N, K;    // 크기
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        K = sc.nextInt();   // 슬라이딩 윈도우

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void printPrefixSum() {   // 구간합

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N - K + 1; i++) {    // 시작 인덱스
            int sum = 0;    // 합

            for(int j = i; j < i + K; j++) {    // K 만큼
                sum += arr[j];  // 더하여
            }

            max = Math.max(max, sum);   // 최대값 갱신
        }

        System.out.println(max);    // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printPrefixSum();   // 구간합 출력
    }
}
