import java.util.*;

/*
2
 */

public class 영화감독숌_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기
        int num = 666, count = 1;   // 초기화

        while(count != N) { // 같지 않으면 반복
            num++;  // 하나씩 키워서

            if(String.valueOf(num).contains("666")) // 666이 포함되는지
                count++;    // 개수 카운트
        }

        System.out.println(num);    // 출력
    }
}
