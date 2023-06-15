import java.util.*;

/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
 */

public class 색종이만들기_백준 {
    static int N;   // 크기
    static int[][] map; // 입력배열
    static int white, blue; // 결과값

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();   // 배열 저장
    }

    public static boolean isSameColor(int x, int y, int size) { // 같은 색깔인지

        int color = map[x][y];  // 기준 색

        for(int i = x; i < x + size; i++)   // 행
            for(int j = y; j < y + size; j++)   // 열
                if(map[i][j] != color)  // 같지않으면
                    return false;   // false

        return true;    // 전부 같으면 true
    }

    public static void DivideAndConquer(int x, int y, int size) {   // 분할 정복

        // 베이스케이스
        if(isSameColor(x, y, size)) {   // 같은 색인지
            if(map[x][y] == 0)
                white++;
            else
                blue++;

            return; // 함수 리턴
        }

        size /= 2;  // 사이즈 갱신

        DivideAndConquer(x, y, size);   // 1
        DivideAndConquer(x, y + size, size);    // 2
        DivideAndConquer(x + size, y, size);    // 3
        DivideAndConquer(x + size, y + size, size); // 4
    }

    public static void main(String[] args) {

        init(); // 초기화

        DivideAndConquer(0, 0, N);  // 분할 정복

        System.out.println(white);  // 값 출력
        System.out.println(blue);
    }
}
