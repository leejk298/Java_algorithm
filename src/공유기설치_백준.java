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
    static int N, M;    // 크기, 공유기 개수
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 개수

        // 초기화
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void BinarySearch() { // 이분 탐색

        Arrays.sort(arr);   // 정렬 => 최악의 경우, 거리 차이를 알기 위해

        int S = 1, E = arr[N - 1] - arr[0]; // 최선은 1: 서로 다르므로, 최악
        int res = 0;    // 결과값
        while (S <= E) {    // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            int count = 1, start = arr[0];  // 개수: 차이를 구하는 것이므로 1부터 시작

            for (int i : arr) { // 순회
                if (mid <= i - start) { // 차이가 더 크면
                    count++;    // 개수 카운트
                    start = i;  // 시작점 갱신
                }
            }

            if (M <= count) {   // 기준 개수보다 크거나 같으면
                res = Math.max(res, mid);   // 조건에 부합하므로 우선 최대값 저장
                S = mid + 1;    // 개수를 더 줄일 수 있는지 시작 인덱스 갱신
            } else  // 작으면
                E = mid - 1;    // 개수를 더 늘리기 위해 끝 인덱스 갱신
        }

        System.out.println(res);    // 최대 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
