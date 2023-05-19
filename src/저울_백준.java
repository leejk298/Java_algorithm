import java.util.*;

/*
6
5
1 2
2 3
3 4
5 4
6 5
 */

public class 저울_백준 {
    static int N, M;    // 크기
    static int[][] map; // DP 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            map[s][e] = 1;  // DP 배열 저장
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜

        for (int k = 1; k <= N; k++) // 경유지 K에 대해
            for (int i = 1; i <= N; i++) // 시작점부터
                for (int j = 1; j <= N; j++) // 끝점까지
                    if (map[i][k] == 1 && map[k][j] == 1)    // 도달 가능하면
                        map[i][j] = 1;  // 1
    }

    public static void printCannotCompare() {   // 비교할 수 없는 노드 개수

        for (int i = 1; i <= N; i++) {   // 행
            int count = 0;  // 개수

            for (int j = 1; j <= N; j++) {   // 열
                if (i == j)  // 같은 것끼리 비교 x
                    continue;

                if (map[i][j] == 0 && map[j][i] == 0)    // 둘 다 0이면 비교할 수 없으므로
                    count++;    // 개수 카운트
            }

            System.out.println(count);  // 개수 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜

        printCannotCompare();   // 출력
    }
}
