import java.util.*;
import java.io.*;

/*
5
....X
..XX.
.....
.XX..
X....
 */

public class 누울자리_백준 {
    static int N, count1, count2;   // 개수
    static char[][] map;    // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        map = new char[N][N];
        count1 = 0; // 가로
        count2 = 0; // 세로

        for (int i = 0; i < N; i++) // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static void printCount() {   // 개수 출력

        for (int i = 0; i < N; i++) {   // 개수만큼
            int cnt1 = 0, cnt2 = 0; // 각 행, 열에 해당하는 가로, 세로 개수

            for (int j = 0; j < N; j++) {   // 개수만큼
                if (map[i][j] == '.')   // 가로
                    cnt1++;

                if (map[i][j] == 'X' || (j == N - 1)) { // 종료 조건
                    if (cnt1 >= 2)  // 해당하는 행에 가로 개수가 2개 이상이면
                        count1++;   // 총 가로 개수 카운트
                    cnt1 = 0;   // 초기화
                }

                if (map[j][i] == '.')   // 세로
                    cnt2++;

                if (map[j][i] == 'X' || (j == N - 1)) {
                    if (cnt2 >= 2)
                        count2++;
                    cnt2 = 0;
                }
            }
        }

        System.out.println(count1 + " " + count2);  // 총 가로, 세로 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCount();   // 개수 출력
    }
}
