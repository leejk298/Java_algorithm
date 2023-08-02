import java.util.*;


public class 싸움짱_삼성SW역량테스트 {
    public static final Player EMPTY = new Player(-1, -1, -1, -1, -1, -1);  // 초기화
    public static int N, M, K;  // 크기
    public static ArrayList<Integer>[][] gun; // 각 칸마다 놓여있는 목록 리스트
    public static Player[] players; // 플레이어 리스트
    public static int[] dx = new int[]{-1, 0, 1,  0}; // ↑, →, ↓, ←
    public static int[] dy = new int[]{ 0, 1, 0, -1};
    public static int[] points; // 점수

    static class Player {	// 플레이어 클래스
        int num, x, y, d, s, a;

        public Player(int num, int x, int y, int d, int s, int a) {
            this.num = num;	// 인덱스
            this.x = x;	// 좌표
            this.y = y;
            this.d = d;	// 이동 방향
            this.s = s;	// 초기 능력치
            this.a = a;	// 주운 권총
        }
    }
    static class Tuple {	// 다음 위치와 방향
        int x, y, dir;

        public Tuple(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static class Pair {		// 좌표
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 진 플레이어 이동 시
        public boolean isSame(Pair p) {	// 해당 좌표에 플레이어가 있는지
            return (this.x == p.x && this.y == p.y);
        }
    }

    public static boolean validPos(int x, int y) {	// 유효한 좌표인지
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();	// 격자 크기
        M = sc.nextInt();	// 플레이어 수
        K = sc.nextInt();	// 라운드

        // 초기화
        gun = new ArrayList[N][N];
        for(int i = 0; i < N; i++) {	// 격자
            for(int j = 0; j < N; j++) {
                gun[i][j] = new ArrayList<>();	// 구현

                int num = sc.nextInt();	// 총 공격력
                if(num != 0)	// 있다면
                    gun[i][j].add(num);	// 저장
            }
        }

        // 초기화
        players = new Player[M];
        points = new int[M];
        for(int i = 0; i < M; i++) {	// 플레이어
            int x = sc.nextInt();	// 좌표
            int y = sc.nextInt();
            int d = sc.nextInt();	// 방향
            int s = sc.nextInt();	// 초기 능력치

            players[i] = new Player(i, x - 1, y - 1, d, s, 0);	// 처음에 권총 x
        }
    }

    // 현재 (x, y)위치에서 방향 d를 보고 있을 때
    // 그 다음 위치와 방향을 찾아줍니다.
    public static Tuple getNext(int x, int y, int d) {

        int tmpX = x + dx[d], tmpY = y + dy[d];	// 다음 위치

        if(!validPos(tmpX, tmpY)) {	// 유효한지
            // 유효하지 않으면 정반대로 이동
            // 0 <-> 2, 1 <-> 3
            d = (d < 2) ? (d + 2) : (d - 2);	// 방향 갱신
            tmpX = x + dx[d];	// 위치 갱신
            tmpY = y + dy[d];
        }

        return new Tuple(tmpX, tmpY, d);	// 값 리턴
    }

    public static Player findPlayer(Pair pos) {

        for(int i = 0; i < M; i++) {	// 플레이어 정보
            // 해당 좌표에
            int x = players[i].x, y = players[i].y;
            // 플레이어가 있으면
            if(pos.isSame(new Pair(x, y)))
                return players[i];	// 해당 플레이어 리턴
        }

        return EMPTY;	// 없으면 EMPTY 리턴
    }

    // Player p의 정보를 갱신해줍니다.
    public static void update(Player p) {	// 위치 이동

        int num = p.num;	// 인덱스

        // 해당 인덱스로 전역변수 접근
        for(int i = 0; i < M; i++) {
            int index = players[i].num;

            if(index == num) {	// 같으면
                players[i] = p;	// 저장

                break;	// 그만 탐색
            }
        }
    }

    // 플레이어 p를 위치 pos로 이동
    public static void move(Player p, Pair pos) {

        int num = p.num, x = p.x, y = p.y, d = p.d, s = p.s, a = p.a;
        int nx = pos.x, ny = pos.y;

        gun[nx][ny].add(a);	// 플레이어 권총 저장
        Collections.sort(gun[nx][ny]);	// 권총 공격력 오름차순 정렬
        a = gun[nx][ny].get(gun[nx][ny].size() - 1); // 제일 쎈 것으로 바꿈
        gun[nx][ny].remove(gun[nx][ny].size() - 1);	// 리스트에서 삭제

        p = new Player(num, nx, ny, d, s, a);	// 객체 생성
        update(p);	// 정보 갱신
    }

    // 진 사람의 움직임을 진행합니다.
    // 결투에서 패배한 위치는 pos입니다.
    public static void loserMove(Player p) {

        int num = p.num, x = p.x, y = p.y, d = p.d, s = p.s, a = p.a;

        // 먼저 현재 위치에 총을 내려놓게 됩니다.
        gun[x][y].add(a);

        // 빈 공간을 찾아 이동하게 됩니다.
        // 현재 방향에서 시작하여
        // 90'씩 시계방향으로
        // 회전하다가
        // 비어있는 최초의 곳으로 이동합니다.
        for(int i = 0; i < 4; i++) {

            int ndir = (d + i) % 4;
            int nx = x + dx[ndir], ny = y + dy[ndir];
            if(validPos(nx, ny) && findPlayer(new Pair(nx, ny)) == EMPTY) {
                p = new Player(num, x, y, ndir, s, 0);
                move(p, new Pair(nx, ny));
                break;
            }
        }
    }

    // p2과 p2가 pos에서 만나 결투를 진행합니다.
    public static void duel(Player p1, Player p2, Pair pos) { // 결투

        int num1 = p1.num, d1 = p1.d, s1 = p1.s, a1 = p1.a;
        int num2 = p2.num, d2 = p2.d, s2 = p2.s, a2 = p2.a;

        // p1이 이긴경우
        if(s1 + a1 > s2 + a2 || (s1 + a1 == s2 + a2 && s1 > s2)) {
            points[num1] += (s1 + a1) - (s2 + a2);

            loserMove(p2);	// 진플레이어 먼저 이동

            move(p1, pos);	// 이긴플레이어 이동
        } else {	// p2가 이긴경우
            points[num2] += (s2 + a2) - (s1 + a1);

            loserMove(p1);

            move(p2, pos);
        }
    }

    public static void simulate() {	// 시뮬레이션

        // 1번 플레이어부터 시작
        for(int i = 0; i < M; i++) {	// 플레이어 정보
            int num = players[i].num;
            int x = players[i].x;
            int y = players[i].y;
            int d = players[i].d;
            int s = players[i].s;
            int a = players[i].a;

            // 현재 플레이어의 다음 위치와 방향
            Tuple next = getNext(x, y, d);
            int nx = next.x, ny = next.y, ndir = next.dir;

            // 다음 위치의 플레이어 정보 확인
            Player nextPlayer = findPlayer(new Pair(nx, ny));

            // 현재 플레이어 생성
            Player curPlayer = new Player(num, nx, ny, ndir, s, a);

            // 현재 플레이어를 전역 배열에 저장
            update(curPlayer);

            // 다음 위치에 다른 플레이어가 없다면
            if(nextPlayer == EMPTY)
                move(curPlayer, new Pair(nx, ny));	// 이동
                // 있다면
            else
                duel(curPlayer, nextPlayer, new Pair(nx, ny));	// 결투
        }
    }

    public static void main(String[] args) {
        init(); // 초기화

        // k번에 걸쳐 시뮬레이션을 진행합니다.
        for(int i = 0; i < K; i++)
            simulate();

        // 각 플레이어가 획득한 포인트를 출력합니다.
        for(int p : points)
            System.out.print(p + " ");
    }
}