import java.util.*;

/*
18
 */

public class 설탕배달_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기
        int count = 0;  // 개수

        while(true) {
            if(N < 0) { // 0 보다 작아지면
                System.out.println(-1); // -1 출력

                break;  // while 종료
            } else if(N % 5 == 0){  // 5의 배수이면
                count += N / 5; // 5개짜리 봉지 추가
                System.out.println(count);  // 개수 출력

                break;  // 반복문 종료
            } else {    // 5의 배수가 아니면
                N -= 3; // 3개짜리 봉지
                count++;    // 추가
            }
        }
    }
}
