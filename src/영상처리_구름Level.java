import java.io.*;
import java.util.*;

public class 영상처리_구름Level {
    public static int N, M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int count;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 행
        N = Integer.parseInt(st.nextToken());   // 열 크기

        map = new char[N][M];   // 맵
        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 한 줄 스트링 -> 문자 배열로

            for(int j = 0; j < M; j++) {    // 열
                map[i][j] = ch[j];  // 저장
            }
        }

        int max = 0, num = 0;   // 가장 큰 크기와 개수
        visited = new boolean[N][M];    // 방문배열
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == '#' && !visited[i][j]) {    // '#'이고 방문하지 않았을 때
                    count = 1;  // 크기
                    BFS(i, j);  // BFS 호출
                    num++;  // 리턴 후 개수 증가

                    if(max < count) // 최대값 찾기
                        max = count;
                }
            }
        }

        System.out.println(num);    // 최대 크기
        System.out.println(max);    // 개수
    }

    public static boolean validPos(int x, int y) {  // 좌표가 유효한지
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(!validPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 값이 유효한지
                    continue;

                if(map[tmpX][tmpY] == '#') {    // '#'이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    count++;    // 크기 증가
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }
}