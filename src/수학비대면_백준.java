import java.util.*;

/*
1 3 -1 4 1 7
 */

public class 수학비대면_백준 {
    static int a, b, c, d, e, f;    // 계수

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        a = sc.nextInt();   // 계수
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();
    }

    public static void printAnswer() {  // 정답 출력

        int x = 0, y = 0;   // 정답 초기화
        boolean flag = false;
        for(int i = -999; i <= 999; i++) {  // -999 ~ 999, x
            for(int j = -999; j <= 999; j++) {  // -999 ~ 999, y
                if((a * i + b * j == c) && (d * i + e * j == f)) {  // 답 찾으면
                    x = i;  // 저장
                    y = j;
                    flag = true;    // for i문 탈출하기 위해

                    break;  // for j문 종료
                }
            }

            if(flag)    // for i문 종료
                break;
        }

        System.out.println(x + " " + y);    // 정답 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printAnswer();  // 정답 출력
    }
}
