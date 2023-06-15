import java.util.*;

/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
 */

public class 종이의개수_백준 {
    static int N;   // 크기
    static int[][] map; // 입력배열
    static int zero, one, minus;    // 결과값

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();   // 배열 저장
    }

    public static boolean isSamePaper(int x, int y, int size) { // 같은 종이인지

        int paper = map[x][y];  // 기준 값

        for(int i = x; i < x + size; i++)   // 행
            for(int j = y; j < y + size; j++)   // 열
                if(paper != map[i][j])  // 하나라도 다르면
                    return false;   // false

        return true;    // 다 같으면 true
    }

    public static void DivideAndConquer(int x, int y, int size) {   // 분할 정복

        // 베이스케이스
        if(isSamePaper(x, y, size)) {   // 같은 종이면
            int paper = map[x][y];  // 기준값

            if(paper == 0)  // 0
                zero++;
            if(paper == 1)  // 1
                one++;
            if(paper == -1) // -1
                minus++;

            return; // 함수 리턴
        }

        // 재귀케이스
        int nextSize = size / 3;    // 다음 크기
        for(int i = x; i < x + size; i += nextSize) // 행
            for(int j = y; j < y + size; j += nextSize) // 열
                DivideAndConquer(i, j, nextSize);   // 재귀
    }

    public static void main(String[] args) {

        init(); // 초기화

        DivideAndConquer(0, 0, N);  // 분할 정복

        System.out.println(minus);  // 결과값 출력
        System.out.println(zero);
        System.out.println(one);
    }
}
