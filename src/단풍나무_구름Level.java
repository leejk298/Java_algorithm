import java.util.*;

public class 단풍나무_구름Level {
    static int N;
    static int[][] map;	// 공원
    static int[][] copy;	// 복사
    static int[] dx = {-1, 1, 0, 0};	// 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() {	// 초기화
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();	// 공원 저장
    }

    public static void simulate() {	// 단풍
        copy = new int[N][N];	// 동시에 바꾸기위해

        for(int i = 0; i < N; i++) {	// 행
            for(int j = 0; j < N; j++) {	// 열
                if(map[i][j] != 0) {	// 물들지않은곳
                    int count = 0;	// 인접구역 단풍나무 개수

                    for(int k = 0; k < 4; k++) {	// 4방향
                        int tmpX = i + dx[k];
                        int tmpY = j + dy[k];

                        if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)	// 유효한좌표
                            continue;

                        if(map[tmpX][tmpY] == 0)	// 인접구역
                            count++;
                    }

                    copy[i][j] = count;	// 복사배열에 개수 저장
                }
            }
        }

        // 동시에 처리
        for(int i = 0; i < N; i++) {	// 행
            for(int j = 0; j < N; j++) {	// 열
                if(map[i][j] == 0)	// 단풍나무이면 건너뛰기
                    continue;
                else if(copy[i][j] > map[i][j])	// 크거나 같으면
                    map[i][j] = 0;	// 0
                else	// 작으면
                    map[i][j] -= copy[i][j];	//
            }
        }
    }

    public static boolean isEnd() {

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(map[i][j] != 0)
                    return false;

        return true;
    }

    public static void main(String[] args) throws Exception {

        init();	// 초기화

        int index = 0;
        while(true) {
            if(isEnd())	// 탈출
                break;

            simulate();	// 단풍

            index++;	// 며칠
        }

        System.out.print(index);
    }
}