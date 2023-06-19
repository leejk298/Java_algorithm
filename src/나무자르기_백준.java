import java.util.*;

/*
4 7
20 15 10 17
 */

public class 나무자르기_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 입력배열
    static int max;     // 최대값

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 최대 높이

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
    }

    public static void BinarySearch() { // 이분 탐색

        int S = 0, E = max; // 인덱스

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            long sum = 0;   // 총합

            for(int i : arr)    // 순회하여
                if(mid < i) // 크면
                    sum += i - mid; // 합

            if(sum >= M)    // 총합이 최대 높이보다 크면
                S = mid + 1;    // 작은쪽 쪽 인덱스 갱신
            else    // 작으면
                E = mid - 1;    // 큰 쪽 인덱스 갱신
        }

        System.out.println(E);  // 역전이 일어나므로 최대 높이 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
