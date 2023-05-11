import java.util.*;

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
 */

public class 치즈_백준 {
    static int N, M;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
    }

    public static boolean checkOne() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 1)
                    return true;

        return false;
    }

    public static boolean isNotValidPos(int x, int y) {
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void meltingCheese() {
        copy = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {    // 1 이면
                    int count = 0;

                    for(int k = 0; k < 4; k++) {    // 4방향
                        int tmpX = i + dx[k], tmpY = j + dy[k];

                        if(isNotValidPos(tmpX, tmpY))
                            continue;

                        if(map[tmpX][tmpY] == 0)
                            count++;
                    }

                    if(count >= 2)
                        copy[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(copy[i][j] == 1)
                    map[i][j] -= copy[i][j];
    }

    public static void main(String[] args) {

        init();

        int t = 0;
        while(checkOne()) {

            t++;

            meltingCheese();
        }

        System.out.println(t);
    }
}
