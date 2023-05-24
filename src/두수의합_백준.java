import java.util.*;

/*
9
5 12 7 10 9 1 2 3 11
13
 */

public class 두수의합_백준 {
    static int N, T;    // 크기, 타겟
    static int[] arr;   // 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        T = sc.nextInt();   // 타겟 숫자
    }

    public static void countSum() { // 두 쌍의 합이 타겟 숫자랑 같은 개수 출력

        Arrays.sort(arr);   // 오름차순 정렬

        int l = 0, r = N - 1, count = 0;    // 투포인터, 개수
        while(l < r) {  // 역전이 아니면
            int sum = arr[l] + arr[r];  // 합

            if(sum == T) {  // 같으면
                count++;    // 개수 카운트
                l++;    // 인덱스 설정
                r--;
            }

            else if(sum > T)    // 크면
                r--;    // 더 작아져야하므로 큰 인덱스 줄이기

            else    // 작으면
                l++;    // 더 커져야하므로 작은 인덱스 키우기
        }

        System.out.println(count);  // 총 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        countSum(); // 두 수의 합 개수 출력
    }
}
