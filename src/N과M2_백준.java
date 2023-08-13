import java.util.*;

/*
4 2
 */

public class N과M2_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 결과배열
    static boolean[] visited;   // 방문배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 숫자 크기
        M = sc.nextInt();   // 결과 크기

        // 초기화
        visited = new boolean[N];
        arr = new int[M];
    }

    public static void BackTracking(int num, int depth) {   // DFS, 백트래킹

        if(depth == M) {    // 베이스케이스, 도달하면
            for(int i : arr)    // 하나씩 출력
                System.out.print(i + " ");

            System.out.println();   // 개행문자 출력

            return; // 함수 리턴, 완전탐색 하기 위해
        }

        for(int i = num; i < N; i++) {  // 숫자 크기만큼
            if(!visited[i]) {   // 방문하지 않았으면
                visited[i] = true;  // 방문여부 갱신
                arr[depth] = i + 1; // 결과배열에 저장
                BackTracking(i + 1, depth + 1); // 재귀콜, 오름차순, 중복제거
                visited[i] = false; // 리턴되면 해당 숫자 방문여부 갱신
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BackTracking(0, 0); // DFS, 백트래킹
    }
}
