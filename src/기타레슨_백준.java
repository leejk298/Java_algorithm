import java.util.*;

/*
9 3
1 2 3 4 5 6 7 8 9
 */

public class 기타레슨_백준 {
    static int N, M;    // 크기, 슬라이딩 윈도우
    static int S, E;    // 인덱스
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 윈도우 크기

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = sc.nextInt();  // 입력배열 저장
            S = Math.max(S, arr[i]);    // 배열의 최대값을 시작 인덱스 => 최소한 이것보다 커야하므로
            E += arr[i];    // 총 합을 끝 인덱스 => 최악의 경우
        }
    }

    public static int getCount(int mid) {   // 개수 카운트

        int sum = 0, count = 0; // 총 합, 개수

        for(int i = 0; i < N; i++) {    // 크기만큼
            if(sum + arr[i] > mid) {    // 합이 중앙값 보다 크면
                sum = 0;    // 초기화
                count++;    // 슬라이딩 윈도우 개수 카운트
            }

            sum += arr[i];  // 합 갱신
        }

        if(sum != 0)    // for 문 끝나고 총 합이 0이 아니면 슬라이딩 윈드우가 더 필요하므로
            count++;    // 개수 카운트

        return count;   // 개수 리턴
    }

    public static void BinarySearch() { // 이분 탐색

        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(getCount(mid) > M)   // 슬라이딩 윈도우 개수가 작으면
                S = mid + 1;    // 시작 인덱스 갱신
            else {  // 크거나 같으면
                E = mid - 1;    // 끝 인덱스 갱신
                res = mid;  // 결과값 저장
            }
        }

        System.out.println(res);    // 결과 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
