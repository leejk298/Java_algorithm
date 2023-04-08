import java.util.*;

/*
5 3
0 0 0 0 0
1 0 0 0 1
0 0 0 0 0
0 1 0 0 0
0 0 0 0 1
2 3
4 4
5 1
*/
public class 코드트리빵_삼성SW역량테스트 {
    static int N, M;	// 격자 크기, 사람 수
    static int[][] map;	// 격자
    static int[][] distance;	// 거리
    static Pair[] c;	// 편의점
    static Pair[] p;	// 사람
    static Pair EMPTY;	// 사람 좌표 초기화
    static boolean[][] visited;	// 방문배열
    static int[] dx = {-1, 0, 0, 1};	// 4방향
    static int[] dy = {0, -1, 1, 0};	// 상 좌 우 하
    static int currentTime;	// 현재시간

    static class Pair {	// Pair 클래스
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Pair p) {	// 좌표가 일치하는지
            return (this.x == p.x && this.y == p.y);
        }
    }

    public static void init() {	// 초기화

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];	// 격자 생성
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();	// 저장

        // 좌표
        c = new Pair[M];	// convenience store
        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            c[i] = new Pair(x - 1, y - 1);	// 편의점 좌표
        }

        p = new Pair[M];	// player
        EMPTY = new Pair(-1, -1);	// 베이스캠프 가기 전, 초기화
        for(int i = 0; i < M; i++)
            p[i] = EMPTY;	// 초기화
    }

    public static boolean validPos(int x, int y) {	// 유효한 좌표인지
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void BFS(Pair p) {	// BFS
        // 방문배열과 거리배열 초기화
        visited = new boolean[N][N];
        distance = new int[N][N];

        Queue<Pair> queue = new LinkedList<>();	// 큐

        queue.offer(p);	// 시작점 추가
        visited[p.x][p.y] = true;	// 방문여부 갱신

        while(!queue.isEmpty()) {	// 큐가 비어있지않으면
            Pair now = queue.poll();	// 하나 꺼내어

            int nowX = now.x, nowY = now.y;	// 현재 좌표
            for(int i = 0; i < 4; i++) {	// 4방향
                int tmpX = nowX + dx[i];
                int tmpY = nowY + dy[i];

                // 이동한 좌표가 유효한지 + 방문하지않았는지 + 갈 수 있는 곳인지 체크
                if(validPos(tmpX, tmpY) && !visited[tmpX][tmpY] &&
                        map[tmpX][tmpY] != 2) {
                    visited[tmpX][tmpY] = true;	// 방문여부 갱신
                    distance[tmpX][tmpY] = distance[nowX][nowY] + 1;	// 거리 업데이트
                    queue.offer(new Pair(tmpX, tmpY));	// 해당 좌표 추가
                }
            }
        }
    }

    public static void simulate() {	// 시뮬레이션
        // 1. 본인이 가고싶은 편의점으로 1칸 이동
        for(int i = 0; i < M; i++) {
            if(p[i] == EMPTY || p[i].isSame(c[i]))	// 격자에 없거나 편의점 도착이면 건너뜀
                continue;

            // 격자에 있으면서 편의점에 도착하지 않은 경우
            // 편의점으로 최단거리 이동을 위해
            // 편의점에 도달해야하므로 편의점 좌표로 BFS 수행
            BFS(c[i]);

            // 현재 사람의 위치에서 최단거리 찾기 - map의 값으로
            int x = p[i].x, y = p[i].y;

            int minDistance = Integer.MAX_VALUE;	// 최단거리
            int minX = -1, minY = -1;	// 초기화
            for(int j = 0; j < 4; j++) {	// 4방향, 상 좌 우 하
                int tmpX = x + dx[j], tmpY = y + dy[j];	// 이동할 좌표
                // 유효한지 + 방문하지않았는지 + 최단거리인지
                if(validPos(tmpX, tmpY) && visited[tmpX][tmpY] &&
                        minDistance > distance[tmpX][tmpY]) {
                    minDistance = distance[tmpX][tmpY];	// 최단거리 갱신
                    minX = tmpX;	// 최단경로 좌표
                    minY = tmpY;
                }
            }
            // 우선순위가 가장 높은 위치로 한 칸 이동
            p[i] = new Pair(minX, minY);
        }

        // 2. 편의점에 도착 => 모든 사람 이동 후 상태 변경
        for(int i = 0; i < M; i++) {
            if(p[i].isSame(c[i])) {	// 도착했는지
                int x = p[i].x, y = p[i].y;
                map[x][y] = 2; // 이동 불가 상태
            }
        }

        if(currentTime > M)	// M 보다 크면 리턴
            return;

        // 3. 현재시간 currentTime <= M 이면
        // t번 사람이 가고싶은 편의점과 가장 가까이 있는
        // 베이스캠프로 이동, 행, 열 작은 순 -> for문에서 자동으로
        // 베캠 이동 후 해당 위치로 이동 불가
        BFS(c[currentTime - 1]);

        // 편의점에서 가장 가까운 베캠
        int minDistance = Integer.MAX_VALUE;	// 최단거리
        int minX = -1, minY = -1;	// 좌표
        for(int i = 0; i < N; i++) {	// 행
            for(int j = 0; j < N; j++) {	// 열
                if(visited[i][j] && map[i][j] == 1 &&
                        minDistance > distance[i][j]) {	// 유효한 좌표 + 갈 수 있는지 + 최단거리
                    minDistance = distance[i][j];	// 최단거리 갱신
                    minX = i;	// 최단경로 좌표 저장
                    minY = j;
                }
            }
        }

        // 가장 가까운 베이스캠프로 이동
        p[currentTime - 1] = new Pair(minX, minY);
        // 해당 베이스캠프로 이동 불가
        map[minX][minY] = 2;
    }

    public static boolean isEnd() {
        // 한 사람이라도 도착 못하면 false
        for(int i = 0; i < M; i++)
            if(!p[i].isSame(c[i]))
                return false;

        return true; // 다 도착이면
    }

    public static void main(String[] args) {
        // 초기화
        init();

        while(true) {
            currentTime++;	// 1분씩 증가

            simulate();		// 시뮬레이션

            if(isEnd()) {	// 다 도착했는지 체크
                System.out.println(currentTime); // 걸린 시간 출력

                break;	// while문 종료
            }
        }
    }
}
