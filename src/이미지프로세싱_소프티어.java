import java.util.*;
import java.io.*;


public class 이미지프로세싱_소프티어 {
    static int H, W;
    static long C[][];
    static boolean visited[][];

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        C = new long[H + 1][W + 1];

        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= W; j++) {
                C[i][j] = Long.parseLong(st.nextToken());
            }
        }

        int Q = Integer.parseInt(bf.readLine());
        for(int i = 0; i < Q; i++) {
            visited = new boolean[H + 1][W + 1];
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long color = Long.parseLong(st.nextToken());
            long exColor = C[x][y];

            imageProcessing(x, y, color, exColor);
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                System.out.print(C[i][j] + " ");
            }

            System.out.println();
        }
    }

    static void imageProcessing(int x, int y, long color, long exColor) {
        if(x < 1 || x > H || y < 1 || y > W ||
                visited[x][y] || C[x][y] != exColor)
            return;

        visited[x][y] = true;
        C[x][y] = color;    // 색상 바꿈

        imageProcessing(x - 1, y, color, exColor);
        imageProcessing(x + 1, y, color, exColor);
        imageProcessing(x, y - 1, color, exColor);
        imageProcessing(x, y + 1, color, exColor);
    }
}