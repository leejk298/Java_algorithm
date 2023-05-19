import java.util.*;

/*
6 6
1 5
3 4
5 4
4 2
4 6
5 2
 */

public class 키순서_백준 {
    static int N, M;    // 크기
    static int[][] map; // DP 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        map = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            map[s][e] = 1;  // DP 배열 저장
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜

        for(int k = 1; k <= N; k++) // 경유지 K에 대해
            for(int i = 1; i <= N; i++) // 시작점부터
                for(int j = 1; j <= N; j++) // 끝점까지
                    if(map[i][k] == 1 && map[k][j] == 1)    // 도달 가능하면
                        map[i][j] = 1;  // 1
    }

    public static void printCanKnow() { // 우열을 알 수 있는 노드 개수

        int sum = 0;    // 총 개수
        for(int i = 1; i <= N; i++) {   // 행
            int count = 0;  // 각 노드당 비교 개수

            for(int j = 1; j <= N; j++) {   // 열
                if(i == j)  // 같은 것끼리 비교 x
                    continue;

                if(map[i][j] + map[j][i] == 1)  // 더하여 1이 되면
                    count++;    // 개수 카운트
            }

            if(count == N - 1)  // 총 개수가 자신 제외한 개수이면
                sum++;  // 총 개수 카운트
        }

        System.out.println(sum);    // 총 개수 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        FloydWarshall();    // 플로이드 워셜

        printCanKnow();     // 비교 가능한 노드 개수 출력
    }
}
