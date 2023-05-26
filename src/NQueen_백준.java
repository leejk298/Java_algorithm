import java.util.*;

/*
8
 */

public class NQueen_백준 {
    static int N, count;    // 크기
    static int[] arr;   // 결과배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        arr = new int[N];   // 초기화
    }

    public static boolean isPossible(int num) { // 가능한지

        for(int i = 0; i < num; i++) {  // 크기만큼
            if(arr[num] == arr[i])  // 같으면
                return false;   // false

            else if(Math.abs(num - i) == Math.abs(arr[num] - arr[i]))   // 대각선 같으면
                return false;   // false
        }

        return true;    // 다른 위치면 true
    }

    public static void BackTracking(int depth) {    // 백트래킹

        if(depth == N) {    // 베이스케이스, 도달하면
            count++;    // 개수 카운트

            return; // 함수 리턴
        }

        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[depth] = i; // 하나씩 저장

            if(isPossible(depth))   // 가능한지
                BackTracking(depth + 1);    // 재귀콜
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BackTracking(0);    // 백트래킹

        System.out.println(count);  // 개수 출력
    }
}
