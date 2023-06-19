import java.util.*;

/*
5 3
1
2
8
4
9
 */

public class 공유기설치_백준 {
    static int N, C;    // 크기
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        C = sc.nextInt();   // 최대거리

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void BinarySearch() { // 이분 탐색

        Arrays.sort(arr);   // 오름차순 정렬

        int S = 1, E = arr[N - 1] - arr[0]; // 인덱스 설정
        int dif = 0, res = 0;   // 차이, 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            int start = arr[0], count = 1;  // 시작값, 개수

            for(int i = 0; i < N; i++) {    // 크기만큼
                dif = arr[i] - start;   // 차이

                if(mid <= dif) {    // 중앙값보다 크면
                    count++;    // 개수 카운트
                    start = arr[i]; // 시작값 갱신
                }
            }

            if(C <= count) {    // 최대 크기보다 크면
                res = mid;  // 결과값 갱신
                S = mid + 1;    // 작은 쪽 인덱스 갱신
            } else  // 작으면
                E = mid - 1;    // 큰 쪽 인덱스 갱신
        }

        System.out.println(res);    // 최대 거리 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
