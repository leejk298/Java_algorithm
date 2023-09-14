import java.util.*;
import java.io.*;

/*
7
0 0 0 1 0 0 0
0 0 0 0 0 0 1
0 0 0 0 0 0 0
0 0 0 0 1 1 0
1 0 0 0 0 0 0
0 0 0 0 0 0 1
0 0 1 0 0 0 0
 */

public class 경로찾기_백준 {
    static int N;   // 크기
    static int[][] map; // 입력배열

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));    // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        map = new int[N][N];    // 초기화
        for (int i = 0; i < N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < N; j++) // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜

        // N이 최대 100이므로 가능
        for (int k = 0; k < N; k++)  // 경유지 K에 대해
            for (int i = 0; i < N; i++)  // 시작점에서
                for (int j = 0; j < N; j++)  // 도착점으로
                    if (map[i][k] == 1 && map[k][j] == 1)    // 경유지를 거쳐서 도달할 수 있으면
                        map[i][j] = 1;  // 도달 가능
    }

    public static void printReachablePath() {    // 도달가능 경로 출력

        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < N; j++)   // 열
                System.out.print(map[i][j] + " ");  // 1이면 도달 가능

            System.out.println();   // 개행문자 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜

        printReachablePath();   // 도달가능 경로 출력
    }
}
