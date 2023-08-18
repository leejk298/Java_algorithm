import java.util.*;
import java.io.*;

public class 가장큰정사각형_DP_091 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        long max = 0; // 한 변의 가장 큰 길이

        int D[][] = new int[N][M]; // 점화식 배열
        for (int i = 0; i < N; i++) { // 행 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            for (int j = 0; j < M; j++) { // 열 개수만큼
                D[i][j] = Integer.parseInt(st.nextToken()); // 배열 저장

                if (D[i][j] == 1 && i > 0 && j > 0) // 배열값이 1 이고 2번째 행, 열부터
                    // D[i][j]가 오른쪽 아래 꼭짓점이므로 대각선, 위, 왼쪽 중 가장 작은 값 + 1 로 세팅
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + 1; // + 1 은 자기자신

                max = Math.max(max, D[i][j]); // 가장 큰 변의 길이
            }
        }

        System.out.println(max * max); // 정사각형 넓이 출력
    }
}