import java.util.*;
import java.io.*;

/*
5 2 2 1
0 0 0 0 0
0 30 23 0 0
0 0 -1 0 0
0 0 17 46 77
0 0 0 12 0
*/

public class 나무박멸_삼성SW역량테스트 {
    static int N, M, K, C;
    static int[][] tree;	// 맵
    static int[][] copy;	// 복사
    static int[][] check;	// 제초
    static int[] dx = { -1, 1, 0, 0 };	// 4방향
    static int[] dy = { 0, 0, -1, 1 };
    static int res;	// 결과

    public static void main(String[] args) {

        init();		// 1. 초기 설정

        for(int i = 0; i < M; i++) {
            grow();		// 2. 성장

            breed(); 	// 3. 번식

            after1year();	// 4. 제초제 기간

            remove();	// 5. 제초
        }

        System.out.println(res);	// 결과 출력
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();	// N
        M = sc.nextInt();	// M
        K = sc.nextInt();	// K
        C = sc.nextInt();	// C

        // 초기화
        res = 0;
        tree = new int[N + 1][N + 1];
        check = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++)	// 맵 저장
            for (int j = 1; j <= N; j++)
                tree[i][j] = sc.nextInt();
    }

    public static boolean notValidPos(int x, int y) {	// 좌표 유효한지
        return !(x >= 1 && x <= N && y >= 1 && y <= N);
    }

    public static void grow() {		// 성장

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(tree[i][j] <= 0)	// 벽이거나 나무가 없거나
                    continue;
                // 나무가 있으면
                int count = 0;
                for(int k = 0; k < 4; k++) {	// 4방향
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if(notValidPos(x, y))	// 좌표가 유효한 지
                        continue;
                    if(tree[x][y] > 0)	// 나무가 있는만큼
                        count++;		// 개수 카운트
                }

                tree[i][j] += count;	// 성장
            }
        }
    }

    public static void breed() {	// 번식
        copy = new int[N + 1][N + 1];	// 복사 배열
        // 초기화
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                copy[i][j] = 0;
        // 맵 순회
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(tree[i][j] <= 0)	// 벽이거나 나무가 없으면
                    continue;	// 건너뛰기

                //나무가 있으면, 주변에 몇 개 있는지 세기
                int count = 0;
                for(int k = 0; k < 4; k++) {	// 4방향
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if(notValidPos(x, y))	// 유효한지
                        continue;
                    if(check[x][y] > 0)		// 제초중인지
                        continue;
                    if(tree[x][y] == 0)		// 주변에 나무가 없으면
                        count++;			// 개수 세기
                }

                // 주변에 있는 나무 개수만큼 나눠서 더해줌
                for(int k = 0; k < 4; k++) {	// 4방향
                    int tmpX = i + dx[k];
                    int tmpY = j + dy[k];

                    if(notValidPos(tmpX, tmpY))
                        continue;
                    if(check[tmpX][tmpY] > 0)
                        continue;
                    if(tree[tmpX][tmpY] == 0)	// 나무가 없으면
                        copy[tmpX][tmpY] += tree[i][j] / count;	// 복사배열에 저장
                }
            }
        }
        // 동시에 삽입하기 위해
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                tree[i][j] += copy[i][j];
    }

    public static void after1year() {	// 제초 1년 후

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                if(check[i][j] > 0)
                    check[i][j] -= 1;
    }

    public static void remove() {	// 제초
        int[] kx = {-1, -1, 1, 1};	// 대각선
        int[] ky = {-1, 1, -1, 1};

        // 가장 많이 지워지는 나무 수, 좌표
        int removeMax = 0;
        int maxI = 1, maxJ = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(tree[i][j] <= 0)	// 벽이거나 나무가 없거나
                    continue;

                // 나무가 있는 경우
                int count = tree[i][j];	// 개수
                for(int d = 0; d < 4; d++) {	// 4방향 대각선
                    int tmpX = i;
                    int tmpY = j;

                    for(int t = 0; t < K; t++) {	// 대각선으로 K만큼
                        tmpX += kx[d];
                        tmpY += ky[d];

                        // 이동한 좌표
                        if(notValidPos(tmpX, tmpY))	// 유효한지
                            break;
                        if(tree[tmpX][tmpY] <= 0)	// 해당 좌표에 나무가 없거나 벽이면
                            break;

                        // 나무인 경우
                        count += tree[tmpX][tmpY];
                    }
                }

                if(removeMax < count) {	// 최대 많이 지워지는 나무 수
                    removeMax = count;
                    maxI = i;	// 좌표 저장
                    maxJ = j;
                }
            }
        }

        res += removeMax;	// 결과값 갱신

        // 제초
        tree[maxI][maxJ] = 0;	// 해당 좌표의 나무 0
        check[maxI][maxJ] = C;	// 제초 갱신

        for(int k = 0; k < 4; k++) {	// 4방향
            int tmpX = maxI;
            int tmpY = maxJ;

            for(int t = 0; t < K; t++) {	// 대각선 k 만큼
                tmpX += kx[k];
                tmpY += ky[k];

                if(notValidPos(tmpX, tmpY))	// 유효한지
                    break;
                if(tree[tmpX][tmpY] < 0)	// 벽인지
                    break;
                if(tree[tmpX][tmpY] == 0) {	// 나무가 없으면
                    check[tmpX][tmpY] = C;	// 제초제는 뿌리고

                    break;					// 더이상 진행 X
                }
                // 나무이면
                tree[tmpX][tmpY] = 0;	// 없애고
                check[tmpX][tmpY] = C;	// 제초제 뿌리고
            }
        }
    }
}