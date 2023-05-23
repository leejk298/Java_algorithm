import java.util.*;

/*
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
 */

public class 나이트의이동_백준 {
    static int N, res;  // 크기, 결과값
    static int[] S, E;  // 시작, 도착점
    static int[][] map; // 맵
    static int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1}; // 나이트의 이동, 8방향
    static int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

    public static void init(Scanner sc) {   // 초기화

        N = sc.nextInt();   // 크기
        res = 0;    // 결과

        // 초기화
        map = new int[N][N];

        int sX = sc.nextInt();  // 시작 x
        int sY = sc.nextInt();  // 시작 y
        S = new int[] {sX, sY}; // 시작 좌표
        map[sX][sY] = 1;    // 맵에 1 저장

        int eX = sc.nextInt();  // 도착 x
        int eY = sc.nextInt();  // 도착 y
        E = new int[] {eX, eY}; // 도착 좌표
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS() {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐
        queue.offer(S); // 시작점 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어
            int nowX = now[0], nowY = now[1];   // 시작 좌표

            if(nowX == E[0] && nowY == E[1]) {  // 도착 좌표와 같으면
                res = map[nowX][nowY] - 1;  // 결과값 저장, 1부터 시작이므로 -1

                break;  // while 탈출
            }

            for(int i = 0; i < 8; i++) {    // 8방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 0이면 == 방문한 적이 없으면
                    map[tmpX][tmpY] = map[nowX][nowY] + 1;  // +1
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int T = sc.nextInt();   // 테스트케이스 개수

        for(int i = 0; i < T; i++) {    // 개수만큼

            init(sc);   // 초기화

            BFS();  // BFS

            System.out.println(res);    // 결과값 출력
        }
    }
}
