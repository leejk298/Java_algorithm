import java.util.*;

/*
10 15
5 1 3 5 10 7 4 9 2 8
 */

public class 부분합_백준 {
    static int N, S, length;    // 크기, 결과
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        S = sc.nextInt();   // 합
        length = 100001;    // 최대값

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void printShortestLength() {  // 최소 길이 출력

        int sum = 0, l = 0, r = 0;  // 구간합, 투포인터

        while(true) {
            if(sum >= S) {  // 합 이상이면
                sum -= arr[l];  // 왼쪽 포인터 하나 빼고
                length = Math.min(length, r - l);   // 길이 저장
                l++;    // 왼쪽 포인터 이동
            }

            else if(r == N) // 도달하면 while 종료
                break;

            else {  // 도달하지 않았고, 합 미만이면
                sum += arr[r];  // 오른쪽 포인터 하나 더하고
                r++;    // 오른쪽 포인터 이동
            }
        }

        if(length == 100001)    // 만족하는 길이가 없으면
            System.out.println(0);  // 0
        else    // 최소 길이
            System.out.println(length); // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printShortestLength();  // 최소 길이 출력
    }
}
