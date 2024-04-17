import java.util.*;
import java.io.*;

public class 다리놓기_조합_079 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        long D[][] = new long[30][30]; // 0 < N <= M < 30, 29까지 포함
        for (int i = 1; i < 30; i++) { // 1부터 29까지
            D[i][1] = i; // i개중 1개 선택: i개
            D[i][i] = 1; // i개중 i개 선택: 1개
        }

        for (int i = 3; i < 30; i++) // 3 ~ 29
            for (int j = 2; j < i; j++) // 2 ~, 선택 수가 총 개수보다 클 수 없음
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j]; // 조합 점화식

        int T = Integer.parseInt(st.nextToken()); // 테스트 개수

        for (int i = 0; i < T; i++) { // 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int N = Integer.parseInt(st.nextToken()); // 선택
            int M = Integer.parseInt(st.nextToken()); // 총 개수

            System.out.println(D[M][N]); // 출력
        }
    }
}
