import java.util.*;
import java.io.*;

/*
YYYYY
SYSYS
YYYYY
YSYYS
YYYYY
 */

public class 소문난칠공주_백준 {
    static int answer;  // 결과값
    static char[][] map;    // 입력배열
    static boolean[] visited;   // 방문배열
    static int[] arr;   // 결과배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        answer = 0; // 결가값
        map = new char[5][5];   // 입력배열
        arr = new int[7];   // 결가배열

        for (int i = 0; i < 5; i++) // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= 5 || y < 0 || y >= 5);
    }

    public static void BFS() {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{arr[0] / 5, arr[0] % 5}); // 가장 처음 값
        visited[0] = true;  // 방문
        int count = 1;  // 개수 카운트

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재좌표

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음좌표
                int index = tmpX * 5 + tmpY;    // 다음 인덱스

                if (isNotValidPos(tmpX, tmpY))  // 좌표가 유효한지
                    continue;

                for (int j = 0; j < 7; j++) {   // 7개가
                    if (!visited[j] && arr[j] == index) {   // 서로 연결되어 있으면
                        queue.offer(new int[]{tmpX, tmpY});  // 큐에 삽입
                        visited[j] = true;  // 방문
                        count++;    // 개수 카운트
                    }
                }
            }
        }

        if (count == 7) // 7개이면
            answer++;   // 결과값 갱신
    }

    public static void BackTracking(int depth, int numY, int start) {   // 백트래킹

        // 베이스케이스
        if (numY >= 4)  // Y가 4개 이상이면
            return; // 건너띄기

        if (depth == 7) {   // 7개 다 뽑으면
            visited = new boolean[7];   // 방문배열 초기화
            BFS();  // BFS

            return; // 완전 탐색하기 위해 리턴
        }

        // 재귀케이스
        for (int i = start; i < 25; i++) {  // 5 * 5
            arr[depth] = i; // 값 저장

            if (map[i / 5][i % 5] == 'Y')   // Y, 몫은 행 / 나머지는 열
                BackTracking(depth + 1, numY + 1, i + 1);
            else    // S
                BackTracking(depth + 1, numY, i + 1);
        }
    }

    public static void printCount() {   // 개수 출력

        BackTracking(0, 0, 0);  // 백트래킹

        System.out.println(answer); // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCount();   // 개수 출력
    }
}
