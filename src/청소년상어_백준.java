import java.util.*;

/*
7 6 2 3 15 6 9 8
3 1 1 8 14 7 10 1
6 1 13 6 4 3 11 4
16 1 8 7 5 2 12 2
 */

public class 청소년상어_백준 {
    static int res; // 최대 결과값
    static int[][] map; // 맵
    static Fish[] fish; // 물고기
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};  // 8방향
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static class Fish { // 물고기 클래스
        int num, x, y, dir; // 숫자, 좌표, 방향
        boolean isAlive;    // 살아있는지

        public Fish(int num, int x, int y, int dir, boolean isAlive) {  // 파라미터 생성자
            this.num = num; // 숫자
            this.x = x; // 좌표
            this.y = y;
            this.dir = dir; // 방향
            this.isAlive = isAlive; // 살아있는지
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        res = 0;    // 결과값

        // 초기화
        map = new int[4][4];
        fish = new Fish[17];    // 1부터

        for (int i = 0; i < 4; i++) {   // 행
            for (int j = 0; j < 4; j++) {   // 열
                int num = sc.nextInt(); // 숫자
                int dir = sc.nextInt() - 1; // 방향

                fish[num] = new Fish(num, i, j, dir, true); // 물고기 객체 생성
                map[i][j] = num;    // 맵 저장
            }
        }
    }

    public static boolean isValidPos(int x, int y) {    // 좌표가 유효한지
        return (x >= 0 && x < 4 && y >= 0 && y < 4);
    }

    public static void moveFish() { // 물고기 이동

        for (int i = 1; i < 17; i++) {  // 16개
            if (!fish[i].isAlive)   // 죽었으면
                continue;   // 건너뛰기

            // 초기화
            int d = 0;
            int dir = fish[i].dir;
            int tmpX = 0, tmpY = 0;

            while (d < 8) { // 8방향
                dir %= 8;   // 유효한 방향으로
                fish[i].dir = dir;  // 갱신

                tmpX = fish[i].x + dx[dir]; // 다음 좌표
                tmpY = fish[i].y + dy[dir];

                if(isValidPos(tmpX, tmpY) && map[tmpX][tmpY] != -1) {   // 유효한지
                    if(map[tmpX][tmpY] == 0) {  // 빈칸이면
                        map[fish[i].x][fish[i].y] = 0;  // 옮겨놓기
                    } else {    // 물고기가 있으면
                        int tmpFish = fish[map[tmpX][tmpY]].num;    // 이동할 위치에 있는 물고기
                        fish[tmpFish].x = fish[i].x;    // 좌표 이동
                        fish[tmpFish].y = fish[i].y;
                        map[fish[tmpFish].x][fish[tmpFish].y] = tmpFish;    // 옮겨놓기
                    }

                    // 물고기 이동
                    fish[i].x = tmpX;
                    fish[i].y = tmpY;
                    map[tmpX][tmpY] = i;

                    break;  // while 종료
                } else {    // 유효하지 않으면
                    dir++;  // 유효한 방향으로
                    d++;    // 이동할 수 있는지 카운트, 8방향 초과하면 이동 x
                }
            }
        }
    }

    public static void moveShark(int sx, int sy, int sd, int eat) { // 상어 이동

        for(int i = 1; i < 4; i++) {    // 최대 3칸까지 이동가능하므로, 1 -> 2 -> 3
            int tmpX = sx + dx[sd] * i, tmpY = sy + dy[sd] * i; // 다음 좌표

            if(isValidPos(tmpX, tmpY) && map[tmpX][tmpY] != 0) {    // 유효한지
                int eatFish = map[tmpX][tmpY];  // 이동할 위치에 있는 물고기
                int tmpD = fish[eatFish].dir;   // 갱신할 방향
                map[sx][sy] = 0;    // 원래위치 0으로
                map[tmpX][tmpY] = -1;   // 상어위치 갱신
                fish[eatFish].isAlive = false;  // 물고기 먹어서 죽음

                DFS(tmpX, tmpY, tmpD, eat + eatFish);   // DFS

                fish[eatFish].isAlive = true;   // 리턴되면 다시 물고기 살리고
                map[sx][sy] = -1;   // 다시 위치 초기화
                map[tmpX][tmpY] = eatFish;
            }
        }
    }

    public static void reCopy(int[][] copyMap, Fish[] copyFish) {   // 원래 위치로 갱신

        for(int i = 0; i < 4; i++)  //  행
            for(int j = 0; j < 4; j++)  // 열
                map[i][j] = copyMap[i][j];  // 위치 제자리로

        for(int i = 1; i < 17; i++) // 16개
            fish[i] = new Fish(copyFish[i].num, copyFish[i].x, copyFish[i].y, copyFish[i].dir, copyFish[i].isAlive);    // 되돌리기
    }

    public static void DFS(int sx, int sy, int sd, int eat) {   // DFS

        res = Math.max(res, eat);   // 최대 먹을 수 있는 물고기 갱신

        // 복사, DFS 완전탐색을 위해서 -> 원래 위치로 갱신시켜야하므로
        int[][] copyMap = new int[4][4];    // 초기화
        for(int i = 0; i < 4; i++)  // 행
            for(int j = 0; j < 4; j++)  // 열
                copyMap[i][j] = map[i][j];  // 복사

        Fish[] copyFish = new Fish[17]; // 초기화
        for (int i = 1; i < 17; i++)    // 16개
            copyFish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].isAlive);    // 복사

        moveFish(); // 물고기 이동

        moveShark(sx, sy, sd, eat); // 상어 이동

        reCopy(copyMap, copyFish);  // 이전 위치로 갱신
    }

    public static void simulation() {   // 시뮬레이션

        int sharkX = 0, sharkY = 0; // 상어 (0, 0)에서 시작
        int sharkD = fish[map[0][0]].dir;   // 방향 갱신
        int eat = map[0][0];    // 먹은 물고기
        fish[map[0][0]].isAlive = false;    // 물고기 죽음
        map[0][0] = -1; // 상어위치 갱신

        DFS(sharkX, sharkY, sharkD, eat);   // DFS
    }

    public static void main(String[] args) {

        init(); // 초기화

        simulation();   // 시뮬레이션

        System.out.println(res);    // 최대로 먹을 수 있는 물고기 값 출력
    }
}
