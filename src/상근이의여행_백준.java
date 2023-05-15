import java.util.*;

/*
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5
 */

public class 상근이의여행_백준 {
    static int N, M, T;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        T = sc.nextInt();   // 테스트 개수

        for(int i = 0; i < T; i++) {    // 개수 만큼
            N = sc.nextInt();   // 노드
            M = sc.nextInt();   // 엣지

            for(int j = 0; j < M; j++) {    // 엣지 개수만큼
                int s = sc.nextInt();   // 시작점
                int e = sc.nextInt();   // 끝점
            }

            System.out.println(N - 1);  // MST 특징: 엣지개수 = N - 1
        }
    }
}
