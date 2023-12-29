import java.util.*;
import java.io.*;

/*
3 5
42101
22100
22101
 */

public class 숫자정사각형_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열
        int len = Math.min(N, M);   // 길이

        int[][] map = new int[N][M];    // 초기화
        for(int i = 0; i < N; i++) {    // 행
            String str = bf.readLine(); // 문자열

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = str.charAt(j) - '0';    // 배열 저장
        }

        while(len > 1) {    // 1보다 크면
            for(int i = 0; i <= N - len; i++) { // 행
                for(int j = 0; j <= M - len; j++) { // 열
                    int num = map[i][j];    // 해당 숫자

                    if(num == map[i][j + len - 1] && num == map[i + len - 1][j] && num == map[i + len - 1][j + len - 1]) {  // 꼭짓점이 같으면
                        System.out.println(len * len); // 길이 출력

                        return; // 함수 종료
                    }
                }
            }

            len--;  // 길이 갱신
        }

        System.out.println(1);  // 여기에 도달하면 최대 1
    }
}
