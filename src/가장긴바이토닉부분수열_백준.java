import java.util.*;

/*
10
1 5 2 1 4 3 4 5 2 1
 */

public class 가장긴바이토닉부분수열_백준 {
    static int N;   // 크기
    static int[] arr, dp1, dp2; // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];

        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = sc.nextInt();  // 입력배열 저장
            dp1[i] = dp2[i] = 1;    // dp 배열 초기화
        }
    }

    public static void LIS1() { // 왼 -> 오른쪽 증가 부분수열 길이

        for(int i = 0; i < N; i++)  // 크기만큼
            for(int j = 0; j < i; j++)  // 이전 값과 비교하여
                if(arr[i] > arr[j]) // 크면
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);  // 해당 증가 길이 저장
    }

    public static void LIS2() { // 오른 -> 왼쪽 증가 부분수열 길이

        for(int i = N - 1; i >= 0; i--) // 크기만큼
            for(int j = N - 1; j > i; j--)  // 이전 값과 비교하여
                if(arr[i] > arr[j]) // 크면
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);  // 해당 증가 길이 저장
    }

    public static void printMaxLength() {   // 최대 길이 출력

        int max = 0;    // 최대값
        for(int i = 0; i < N; i++)  // 크기만큼
            max = Math.max(max, dp1[i] + dp2[i]);   // 최대값 구하기

        System.out.println(max - 1);    // 가운데 인덱스 겹치므로 -1
    }

    public static void main(String[] args) {

        init(); // 초기화

        LIS1(); // 왼 -> 오 증가 수열

        LIS2(); // 오 -> 왼 증가 수열

        printMaxLength();   // 최대 길이 출력
    }
}
