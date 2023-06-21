import java.util.*;

/*
10 8
 */

public class 게임_백준 {

    public static int winPercent(int x, int y) {    // 승률 구하기

        return (int) ((long)y * 100 / x);   // 100을 곱하면 int 범위 넘어가므로 long 형변환
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        // 초기화
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = winPercent(X, Y);   // 승률 구하기

        int S = 0, E = 1000000000;  // 인덱스 설정
        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(winPercent(X + mid, Y + mid) != Z) { // 승률이 다르면
                E = mid - 1;    // 끝 인덱스 갱신
                res = mid;  // 결과값 저장
            } else  // 같으면
                S = mid + 1;    // 시작 인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }
}
