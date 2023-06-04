import java.util.*;

/*
216
 */

public class 분해합_백준 {
    static int N, size, start;  // 크기

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 입력 숫자
        size = String.valueOf(N).length();  // 자리수
        start = N - size * 9;   // 최대 9까지 가능하므로 자릿수 x 9를 뺀 숫자부터 시작
    }

    public static int modulo(int num) { // 모듈로 연산

        int sum = num;  // 초기값
        while(num != 0) {   // 0이 아니면
            sum += num % 10;    // 한 자리씩 더해
            num /= 10;  // 다음 자리수로
        }

        return sum; // 합 리턴
    }

    public static void printConstructor() { // 생성자 출력

        int res = 0;    // 0으로 초기화
        for(int i = start; i < N; i++) {    // 시작값부터 N까지 검사
            int num = modulo(i);    // 모듈로 연산

            if(num == N) {  // N이랑 같으면
                res = i;    // 저장

                break;  // for 종료
            }
        }

        System.out.println(res);    // 있으면 값을 출력하고 없으면 0 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printConstructor(); // 생성자 출력
    }
}
