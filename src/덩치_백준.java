import java.util.*;
import java.io.*;

/*
5
55 185
58 183
88 186
60 175
46 155
 */

public class 덩치_백준 {
    static int N;   // 크기
    static int[][] arr; // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        arr = new int[N][2];    // 입력배열
        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int w = Integer.parseInt(st.nextToken());   // 몸무게
            int h = Integer.parseInt(st.nextToken());   // 키

            arr[i] = new int[]{w, h};   // 입력배열 저장
        }
    }

    public static void printRank() {    // 순위 출력

        StringBuilder sb = new StringBuilder(); // 결과문자열

        for (int i = 0; i < N; i++) {   // 크기만큼
            int rank = 1;   // 순위 1부터

            for (int j = 0; j < N; j++) {   // 비교 대상
                if (i == j) // 같으면
                    continue;   // 건너뛰기

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) // 몸무게, 키가 다 작으면
                    rank++; // 후순위로
            }

            sb.append(rank + " ");  // 순위 저장
        }

        System.out.println(sb); // 결과문자열 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printRank();    // 순위 출력
    }
}
