import java.util.*;

/*
4 11
802
743
457
539
 */

public class 랜선자르기_백준 {

    public static long BinarySearch(int[] arr, int K, long max) {   // 이분탐색

        long min = 1, mid = 0;  // 초기화

        while(min <= max) {  // 역전이 아니면 반복
            mid = (max + min) / 2;  // 중앙값

            long count = 0; // 개수
            for(long num : arr) // 순회
                count += num / mid; // 개수 카운트

            if(count < K)   // 작으면
                max = mid - 1;  // 큰 쪽 인덱스 갱신
            else    // 크면
                min = mid + 1;  // 작은 쪽 인덱스 갱신
        }

        return (max + min) / 2; // 최대 길이 리턴
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기
        int K = sc.nextInt();   // 필요한 개수

        // 초기화
        int[] arr = new int[N];
        long max = 0, res = 0;

        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = sc.nextInt();  // 저장
            max = Math.max(max, arr[i]);    // 최대값 저장
        }

        res = BinarySearch(arr, K, max);    // 이분탐색

        System.out.println(res);    // 결과값 출력
    }
}
