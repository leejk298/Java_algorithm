import java.util.*;

/*
5
1 2 2 3 3
2 2 2 3 3
2 2 1 3 1
2 2 1 1 1
2 2 1 1 1
*/


public class 예술성_삼성SW역량테스트 {
    static int N;    // 크기
    static int[][] arr;    // 배열
    static int[][] copy;    // 복사
    static boolean[][] visited;    // 방문배열
    static int groupN;    // 그룹개수
    static int[][] group;    // 그룹번호
    static int[] groupCount;    // 개수
    static int[] dx = {1, -1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static int answer;    // 결과

    public static boolean validPos(int x, int y) {    // 좌표가 유효한지
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void init() {    // 초기화

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();    // 크기

        arr = new int[N][N];    // 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
    }

    public static void DFS(int x, int y) {    // DFS
        for (int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i];    // 인접한 좌표

            // 유효한지 + 방문가능한지 + 같은 그룹가능
            if (validPos(tmpX, tmpY) && !visited[tmpX][tmpY] &&
                    arr[tmpX][tmpY] == arr[x][y]) {
                visited[tmpX][tmpY] = true;    // 방문여부 갱신

                group[tmpX][tmpY] = groupN;    // 그룹
                groupCount[groupN]++;    // 개수 세기

                DFS(tmpX, tmpY);    // 같은 그룹 찾기
            }
        }
    }

    public static void makeGroup() {    // 그룹 만들기
        // 초기화
        visited = new boolean[N][N];
        group = new int[N][N];
        groupCount = new int[N * N + 1];    // 총 N^2개 가능이고 1부터 시작

        groupN = 0;
        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < N; j++) {    // 열
                if (!visited[i][j]) {    // 방문하지 않았으면
                    visited[i][j] = true;

                    groupN++;    // 그룹개수 및 이름
                    group[i][j] = groupN;    // 그룹 저장
                    groupCount[groupN]++;    // 개수 세기

                    DFS(i, j);    // DFS
                }
            }
        }
    }

    public static int getArtScore() {    // 예술점수
        int sum = 0;    // 합

        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < N; j++) {    // 열
                for (int k = 0; k < 4; k++) {    // 4방향
                    int tmpX = i + dx[k], tmpY = j + dy[k];    // 인접한 좌표
                    // 유효한지 + 다른 그룹인지
                    if (validPos(tmpX, tmpY) && arr[tmpX][tmpY] != arr[i][j]) {
                        int g1 = group[i][j], g2 = group[tmpX][tmpY];
                        int num1 = arr[i][j], num2 = arr[tmpX][tmpY];
                        int cnt1 = groupCount[g1], cnt2 = groupCount[g2];

                        sum += (cnt1 + cnt2) * num1 * num2;    // 합
                    }
                }
            }
        }

        return sum / 2;    // 인접한 그룹의 좌표들
        //수행하므로 중복이므로 나누기
    }

    public static int getScore() {    // 점수 구하기
        makeGroup();    // 1. 그룹 만들기

        return getArtScore();    // 예술점수 구하기
    }

    public static void rotateSquare(int x, int y, int len) {    // 모서리 사각형 회전

        for (int i = x; i < x + len; i++) {    // 행, 시작점부터 길이만큼
            for (int j = y; j < y + len; j++) {    // 열
                int tmpX = i - x, tmpY = j - y;    // (0, 0)으로 변환

                int rx = tmpY, ry = len - 1 - tmpX;    // 변환된 상태에서의 회전 후 좌표

                copy[rx + x][ry + y] = arr[i][j];    // 복사하기
            }
        }
    }

    public static void rotate() {    // 회원

        copy = new int[N][N];    // 복사 배열

        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < N; j++) {    // 열
                if (j == N / 2)    // 세로 줄이면
                    copy[j][i] = arr[i][j];    // (i, j) -> (j, i)
                else if (i == N / 2)    // 가로 줄이면
                    copy[N - 1 - j][i] = arr[i][j];    // (i, j) -> (N - 1 - j, i)
            }
        }

        int sLen = N / 2;    // 가운데 줄 제외이므로
        rotateSquare(0, 0, sLen);    // 왼쪽 위
        rotateSquare(0, sLen + 1, sLen);    // 오른쪽 위
        rotateSquare(sLen + 1, 0, sLen);    // 왼쪽 아래
        rotateSquare(sLen + 1, sLen + 1, sLen);    // 오른쪽 아래

        // 열
        // 회전 결과
        for (int i = 0; i < N; i++)    // 행
            System.arraycopy(copy[i], 0, arr[i], 0, N);
    }

    public static void main(String[] args) {

        init();    // 초기화

        answer = 0;    // 결과
        for (int i = 0; i < 4; i++) {    // 3회전이지만, 계산 후 회전이므로 4
            answer += getScore();    // 점수 더하기

            rotate();    // 회전
        }

        System.out.println(answer);    // 결과 출력
    }
}