import java.util.*;

/*
3
7
 */

public class K번째수_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기
        int K = sc.nextInt();   // K번째 수

        int S = 1, E = K;   // 인덱스
        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            int count = 0;  // 개수 카운트

            for(int i = 1; i <= N; i++) // 크기만큼
                count += Math.min(mid / i, N);  // 개수 카운트

            if(K <= count) {    // 작거나 같으면
                res = mid;  // 결과값 저장
                E = mid - 1;    // 큰 쪽 인덱스 갱신
            } else  // 크면
                S = mid + 1;    // 작은 쪽 인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }
}
