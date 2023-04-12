import java.util.*;

public class 폭탄구현하기_구름Level {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int N = sc.nextInt();
        int K = sc.nextInt();

        int sum = K;
        for(int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int k = 0; k < 4; k++) {
                int tmpX = x + dx[k];
                int tmpY = y + dy[k];

                if(tmpX >= 1 && tmpX <=N && tmpY >=1 && tmpY <= N)
                    sum++;
            }
        }

        System.out.print(sum);
    }
}