import java.util.*;

public class 중복조합 {
    static int N;    // 총 개수
    static int M;    // 뽑을 개수
    static int A[];  // 주어진 숫자배열
    static int res[]; // 결과배열

    public static void dfs(int v, int w) {   // dfs

        if (v == M) {   // 뽑을 개수와 같으면
            for (int i : res) // 배열 res 를 i로 순회하면서
                System.out.print(i);  // 출력
            System.out.println();   // 개행문자 출력
        } else {    // 뽑을 개수보다 작으면
            for (int i = w; i < N; i++) {   // 주어진 숫자들 개수만큼
                res[v] = A[i];   // 결과배열에 저장
                dfs(v + 1, i); // 개수 + 1, 다음 뽑을 숫자 - 중복 가능하므로 그대로
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        res = new int[M];

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        dfs(0, 0); // v: 뽑을 개수 count, w: 뽑을 숫자 => A[index]
    }
}
