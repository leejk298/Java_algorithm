import java.nio.Buffer;
import java.util.*;
import java.io.*;

/*
5 8
....XXXX
........
XX.X.XX.
........
........
 */

public class 성지키기_백준 {
    static int N, M;    // 크기
    static char[][] map;    // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        map = new char[N][M];   // 초기화

        for (int i = 0; i < N; i++) // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static void printCount() {   // 개수 출력

        int count1 = 0, count2 = 0; // 가로, 세로 개수

        for (int i = 0; i < N; i++) {   // 행
            boolean flag = false;

            for (int j = 0; j < M; j++) {   // 열
                if (map[i][j] == 'X') { // X 이면
                    flag = true;

                    break; // for - j문 종료
                }
            }

            if (!flag)  // 해당 행에 X가 없으면
                count1++;   // 가로 개수 카운트
        }

        for (int i = 0; i < M; i++) {   // 열
            boolean flag = false;

            for (int j = 0; j < N; j++) {   // 행
                if (map[j][i] == 'X') { // X 이면
                    flag = true;

                    break;  // for - j문 종료
                }
            }

            if (!flag)  // 해당 열에 X가 없으면
                count2++;   // 세로 개수 카운트
        }

        System.out.println(Math.max(count1, count2));   // 최대 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCount();   // 개수 출력
    }
}
