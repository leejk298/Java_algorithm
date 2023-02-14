import java.util.Scanner;

public class 소수_팰린드롬수_에라토스테네스의체_039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 시작
        int A[] = new int[10000001];	// 배열

        for (int i = 2; i < A.length; i++)	// 크기 만큼
            A[i] = i;	// 배열 저장

        for (int i = 2; i <= Math.sqrt(A.length); i++) {	// 제곱근까지 비교하여
            if (A[i] == 0)	// 소수가 아니면 통과
                continue;

            // 소수이면
            for (int j = i + i; j < A.length; j = j + i)	// 해당 숫자의 배수
                A[j] = 0;	// 소수가 아니라고 설정
        }

        for (int i = N; i < A.length; i++)	// 크기 만큼
            if (A[i] != 0) {	// 소수이면
                int res = A[i];	// 해당 숫자를

                if (isPalindrome(res)) {	// 팰린드롬 수인 지 체크
                    System.out.println(res);	// 맞으면 출력

                    break;	// 가장 작은 수 찾았으니 반복문 종료
                }
            }

    }

    private static boolean isPalindrome(int X) {	// 팰린드롬 수 체크 함수
        char tmp[] = String.valueOf(X).toCharArray();	// 숫자 배열을 문자 배열로 저장
        int S = 0, E = tmp.length - 1;	// 시작과 끝 index 설정

        while (S < E) {	// 반복문 돌면서
            if (tmp[S] != tmp[E])	// 서로 다르면
                return false;		// false

            S++;	// 인덱스 조정
            E--;
        }

        return true;	// 전부 다 돌았으면 다 팰린드롬 수이므로 true
    }
}
