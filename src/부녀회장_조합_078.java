import java.util.*;

public class 부녀회장_조합_078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int D[][] = new int[15][15]; // 조합배열
        for (int i = 0; i <= 14; i++) { // 14호 까지
            D[0][i] = i; // 0층의 i호는 i명
            D[i][1] = 1; // i층 1호는 1명
        }

        for (int i = 1; i <= 14; i++) // 1층부터 14층까지
            for (int j = 2; j <= 14; j++) // 2호부터 14호까지
                D[i][j] = D[i][j - 1] + D[i - 1][j]; // 점화식

        int T = sc.nextInt(); // 테스트 개수
        for (int i = 0; i < T; i++) { // 개수만큼
            int x = sc.nextInt(); // 층
            int y = sc.nextInt(); // 호

            System.out.println(D[x][y]); // 값 출력
        }
    }
}
