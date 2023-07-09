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

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {    // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            arr[i][0] = Integer.parseInt(st.nextToken());   // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken());   // 키
        }
    }

    public static void printRank() {    // 순위 출력

        StringBuilder sb = new StringBuilder(); // 결과 문자열

        for(int i = 0; i < N; i++) {    // 크기만큼
            int rank = 1;   // 순위 1부터

            for(int j = 0; j < N; j++) {    // 비교
                if(i == j)  // 같은 것은 건너뛰기
                    continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])  // 둘 다 작으면
                    rank++; // 순위를 높임
            }

            sb.append(rank + " ");  // 해당 순위 추가
        }

        System.out.println(sb); // 총 순위 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printRank();    // 순위 출력
    }
}
