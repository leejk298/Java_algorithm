import java.util.*;
import java.io.*;


public class 이미지프로세싱_소프티어 {
    static int H, W;    // 크기
    static long C[][];  // 입력배열
    static boolean visited[][]; // 방문배열

    public static void imageProcessing(int x, int y, long color, long exColor) {    // 이미지프로세싱

        if (x < 1 || x > H || y < 1 || y > W || visited[x][y] || C[x][y] != exColor)    // 베이스케이스: 유효하지 않으면
            return; // 리턴

        // 재귀케이스: 유효하면
        visited[x][y] = true;   // 방문
        C[x][y] = color;    // 색상 바꿈

        imageProcessing(x - 1, y, color, exColor); // 재귀콜
        imageProcessing(x + 1, y, color, exColor);
        imageProcessing(x, y - 1, color, exColor);
        imageProcessing(x, y + 1, color, exColor);
    }

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        H = Integer.parseInt(st.nextToken());   // 높이
        W = Integer.parseInt(st.nextToken());   // 너비
        C = new long[H + 1][W + 1]; // 입력배열 초기화

        for (int i = 1; i <= H; i++) {  // 높이만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 1; j <= W; j++)  // 너비만큼
                C[i][j] = Long.parseLong(st.nextToken());   // 입력배열 저장
        }

        int Q = Integer.parseInt(bf.readLine());    // 크기

        for (int i = 0; i < Q; i++) {   // 크기만큼
            visited = new boolean[H + 1][W + 1];    // 방문배열 초기화

            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int x = Integer.parseInt(st.nextToken());   // x
            int y = Integer.parseInt(st.nextToken());   // y
            long color = Long.parseLong(st.nextToken());    // 현재 색깔
            long exColor = C[x][y]; // 이전 색깔

            imageProcessing(x, y, color, exColor);  // 이미지프로세싱
        }

        for (int i = 1; i <= H; i++) {  // 높이만큼
            for (int j = 1; j <= W; j++)    // 너비만큼
                System.out.print(C[i][j] + " ");    // 입력배열 출력
            System.out.println();   // 개행문자 출력
        }
    }
}