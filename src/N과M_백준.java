import java.util.*;

/*
4 2
 */

public class N과M_백준 {
    static int N, M;    // 크기
    static boolean[] visited;   // 방문배열
    static int[] arr;   // 결과배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 숫자 크기
        M = sc.nextInt();   // 출력 크기

        // 초기화
        arr = new int[M];
        visited = new boolean[N];
    }

    public static void BackTracking(int depth) {    // 백트래킹

        if(depth == M) {    // 출력 크기와 같으면
            for(int i : arr)    // 결과배열 하나씩
                System.out.print(i + " ");  // 출력

            System.out.println();   // 개행문자 출력

            return; // 리턴
        }

        for(int i = 0; i < N; i++) {    // 숫자 크기만큼
            if(!visited[i]) {   // 방문하지 않았으면, 중복 X
                visited[i] = true;  // 방문여부 갱신
                arr[depth] = i + 1; // 0부터이므로 + 1

                BackTracking(depth + 1);    // 백트래킹, 출력 크기 + 1

                visited[i] = false; // 리턴되면 해당 숫자 방문여부 갱신
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        BackTracking(0);    // 백트래킹
    }
}
