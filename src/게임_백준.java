import java.util.*;

/*
10 8
 */

public class 게임_백준 {

    public static long winPercent(long x, long y) {    // 승률 구하기

        return y * 100 / x;   // 100을 곱하면 int 범위 넘어갈 수 있으므로 long 형변환
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        // 초기화
        long X = sc.nextLong();
        long Y = sc.nextLong();
        long Z = winPercent(X, Y);   // 승률 구하기

        if (Z >= 99)    // 99 이상이면
            System.out.println(-1); // 바뀔 수 없으므로 -1 출력

        else {  // 99 미만이면
            long S = 1, E = X;  // 인덱스 설정, E: 최악의 경우 => 최대 판 수
            long res = 0;    // 결과값

            while (S <= E) { // 역전이 아니면 반복
                long mid = (S + E) / 2;  // 중앙값

                if (winPercent(X + mid, Y + mid) > Z) { // 승률보다 크면
                    E = mid - 1; // 끝 인덱스 갱신
                    res = mid;  // 결과값 저장
                } else  // 같거나 작으면
                    S = mid + 1;    // 시작 인덱스 갱신
            }

            System.out.println(res);    // 결과값 출력
        }
    }
}
