import java.util.*;
import java.io.*;

public class 계단수_DP_088 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 길이
        long D[][] = new long[10][N + 1]; // 높이(0 ~ 9), 길이(0 ~ N)로 이루어진 계단

        for (int h = 1; h <= 9; h++) // 길이 1인 계단 초기화
            D[h][1] = 1; // 길이가 1인 계단에서 높이가 h로 끝나는 계단 수: 1
        // 길이가 1인 계단에서 높이가 0으로 끝나는 계단 수를 만들 수 없으므로 0, D[0][1] = 0

        for (int i = 2; i <= N; i++) { // 길이 2 ~ N
            D[0][i] = D[1][i - 1]; // 높이가 0 => 이전에 높이가 1밖에 없음
            D[9][i] = D[8][i - 1]; // 높이가 9 => 이전에 높이가 8밖에 없음

            for (int j = 1; j <= 8; j++) // 높이가 1 ~ 8
                D[j][i] = D[j - 1][i - 1] + D[j + 1][i - 1]; // 이전에 높이가 -1, +1 가능
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) // 높이 만큼
            sum += D[i][N]; // 길이 N의 총 경우의 수

        System.out.println(sum); // 출력
    }
}
