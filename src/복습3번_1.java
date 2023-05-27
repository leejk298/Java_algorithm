import java.util.*;

public class 복습3번_1 {   // 내가 푼 방법
    static int N, M;    // 크기
    static int[] arr;   // 공정 배열
    static int[] S, T;  // 시작, 끝 배열

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 공정 크기
        M = sc.nextInt();   // 결과 크기

        // 초기화
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++) // 1 부터
            arr[i] = sc.nextInt();

        S = new int[M];
        T = new int[M];
        for(int i = 0; i < M; i++) {
            S[i] = sc.nextInt();    // 시작
            T[i] = sc.nextInt();    // 끝
        }
    }

    public static long printCountSum() {    // 총합 개수
        long sum = 0;   // 총합

        for(int i = 0; i < M; i++) {    // 크기만큼
            int start = S[i], end = T[i];   // 시작, 끝 구간

            for(int j = start; j <= end; j++) { // 구간만큼
                if(arr[j] == 1) // 1 이면
                    sum++;  // 개수 카운트
            }
        }

        return sum; // 총합 개수 카운트
    }

    public static void main(String[] args) {

        init(); // 초기화, O(N) + O(M)

        System.out.println(printCountSum());    // 총합 개수 출력, O(N * M) => M개의 구간이 전부 처음부터 끝까지면 N => 최적화 필요 => 누적합배열
    }
}
