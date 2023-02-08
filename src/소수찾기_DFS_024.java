import java.util.Scanner;

public class 소수찾기_DFS_024 {
    static int N;	// 정적 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        N = sc.nextInt();	// 자릿수

        // 2, 3, 5, 7은 1의 자리에서 소수이므로
        DFS(2, 1);	// 2 -> 2x -> 2xx -> 2xxx 전부 소수인 숫자 찾기
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int num, int jarisu) {
        if (jarisu == N) {	// 자릿수가 같으면
            if (is_prime(num)) {	// 소수이면
                System.out.println(num);	// 출력
            }

            return;	// 소수가 아니면 리턴
        }

        for (int i = 1; i < 10; i++) {	// 다음 자릿수 찾기 -> 다음 자릿수도 소수여야되므로
            if (i % 2 == 0)	// 짝수면 소수가 안되므로 다음으로
                continue;

            if (is_prime(num * 10 + i))	// 다음 자릿수 합쳐서 소수이면
                DFS(num * 10 + i, jarisu + 1);	// DFS 재귀콜
        }
    }

    private static boolean is_prime(int num) {	// 소수 체크
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
