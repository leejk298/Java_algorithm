import java.util.*;
import java.io.*;

/*
6 9
-||--||--
--||--||-
|--||--||
||--||--|
-||--||--
--||--||-
 */

public class 바닥장식_백준 {
    static int N, M;    // 크기
    static char[][] map;    // 맵
    static boolean[][] visited; // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++)  // 행 개수만큼
            map[i] = bf.readLine().toCharArray();   // 한 줄 받아서 문자형 배열에 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지, 오른쪽 or 아래쪽으로만 이동하므로
        return (x >= N || y >= M);
    }

    public static void DFS(int x, int y) {  // DFS

        visited[x][y] = true;   // 방문여부 갱신

        if(map[x][y] == '-') {  // - 이면 오른쪽 이동
            int tmpX = x + 0, tmpY = y + 1; // (0, 1) 이동, 다음 좌표

            if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                return;

            if(map[tmpX][tmpY] == '-')  // 다음 좌표가 - 이면
                DFS(tmpX, tmpY);    // DFS
        } else {    // | 이면 아래쪽 이동
            int tmpX = x + 1, tmpY = y + 0; // (1, 0) 이동, 다음 좌표

            if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                return;

            if(map[tmpX][tmpY] == '|')  // 다음 좌표가 | 이면
                DFS(tmpX, tmpY);    // DFS
        }
    }

    public static int printBoardCount() {   // 총 나무 판자 개수
        int count = 0;  // 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(!visited[i][j]) {    // 방문하지 않았으면
                    DFS(i, j);  // DFS
                    count++;    // 개수 카운트
                }
            }
        }

        return count;   // 총 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(printBoardCount());  // 총 판자 개수 출력
    }
}
