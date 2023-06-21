import java.util.*;

/*
4
120 110 140 150
485
 */

public class 예산_백준 {
    static int N, M;    // 크기, 총 예산
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        M = sc.nextInt();   // 총 예산
    }

    public static void BinarySearch() { // 이분 탐색

        Arrays.sort(arr);   // 오름차순 정렬, 이분 탐색하기 위해

        int S = 1, E = arr[N - 1];  // 인덱스, E: 최악의 경우
        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            long sum = 0;   // 총 합

            for(int i : arr) {  // 배열 순회
                if(i >= mid)    // 크거나 같으면
                    sum += mid; // 중앙값을 더하고
                else    // 작으면
                    sum += i;   // 해당 값을 더함
            }

            if(sum <= M) {  // 합이 총 예산보다 작거나 같으면
                S = mid + 1;    // 시작 인덱스 갱신
                res = mid;  // 조건을 만족하므로 결과값 저장
            } else  // 크면
                E = mid - 1;    // 끝 인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
