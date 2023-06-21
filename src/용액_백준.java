import java.util.*;

/*
5
-99 -2 -1 4 98
 */

public class 용액_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void BinarySearch() { // 이진 탐색

        int S = 0, E = N - 1;   // 인덱스
        long min = Integer.MAX_VALUE;   // 최소값
        int x = 0, y = 0;   // 결과값

        while(S < E) {  // 역전이 아니면 반복
            long sum = arr[S] + arr[E]; // 합

            if(min >= Math.abs(sum)) {  // 작으면
                min = Math.abs(sum);    // 최소값 갱신
                x = arr[S]; // 알칼리성 용액
                y = arr[E]; // 산성 용액
            }

            if(sum < 0) // 0 보다 작으면
                S++;    // 커져야 하므로 시작 인덱스 갱신
            else    // 크거나 같으면
                E--;    // 작아져야 하므로 끝 인덱스 갱신
        }

        System.out.println(x + " " + y);    // 용액 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        BinarySearch(); // 이진 탐색
    }
}
