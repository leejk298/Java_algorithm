import java.util.*;

public class 팩토리얼_백준 {
    static int N;   // 크기

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
    }

    public static void printFactorial() {   // 팩토리얼 값 출력

        if(N == 0 || N == 1)    // 0 이나 1이면
            System.out.println(1);  // 1 출력
        else {  // 1 보다 크면
            int sum = 1;    // 곱해야하므로 1
            for(int i = 1; i <= N; i++) // 크기까지
                sum *= i;   // 곱하여

            System.out.println(sum);    // 값 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printFactorial();   // 팩토리얼 값 출력
    }
}
