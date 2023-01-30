import java.util.Scanner;

public class K번째수_BinarySearch_031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int K = sc.nextInt(); // k번째 숫자
        long S = 1, E = K; // 시작, 끝 => K번째 수는 K를 넘지 못함
        long res = 0; // 결과

        while (S <= E) {
            long mid = (S + E) / 2; // 중앙값
            long cnt = 0;

            for (int i = 1; i <= N; i++) // index가 1 부터 => 행마다
                cnt += Math.min(mid / i, N); // 중앙값을 행으로 나눈값과 행 중에 작은 값을 cnt에 더함

            if (cnt < K) // cnt가 K보다 작으면
                S = mid + 1; // S 설정

            else { // 크면
                res = mid; // 결과를 저장한 후
                E = mid - 1; // E 설정
            }
        }

        System.out.println(res); // 결과 출력
    }
}
