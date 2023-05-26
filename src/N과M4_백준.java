import java.util.*;

/*
4 2
 */

public class N과M4_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 결과배열
    static StringBuilder sb;    // 문자열 생성

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 숫자 크기
        M = sc.nextInt();   // 결과 크기

        // 초기화
        sb = new StringBuilder();
        arr = new int[M];
    }

    public static void BackTracking(int num, int depth) {    // 백트래킹

        if(depth == M) {    // 베이스케이스, 도달하면
            for(int i : arr)    // 배열 하나씩
                sb.append(i + " "); // 문자열 만들기

            sb.append("\n");    // 개행문자 추가
            return; // 함수 리턴
        }

        for(int i = num; i < N; i++) {    // 숫자 크기만큼
            arr[depth] = i + 1; // 하나씩 저장
            BackTracking(i, depth + 1);    // 재귀콜
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BackTracking(0, 0);    // 백트래킹

        System.out.println(sb); // 결과 문자열 출력
    }
}