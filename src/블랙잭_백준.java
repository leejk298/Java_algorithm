import java.util.*;

/*
5 21
5 6 7 8 9
 */

public class 블랙잭_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();   // 경계값

        // 초기화
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
    }

    public static void printCloseCardSum() {    // M에 가장 가까운 숫자 출력

        int sum = 0, res = 0;   // 합, 결과값
        for (int i = 0; i < N - 2; i++) {   // 첫 번째 카드
            for (int j = i + 1; j < N - 1; j++) {   // 두 번째 카드
                for (int k = j + 1; k < N; k++) {   // 세 번째 카드
                    sum = arr[i] + arr[j] + arr[k]; // 합

                    if(sum <= M && res < sum)   // M보다 크지않고 가장 가까운 수
                        res = sum;  // 저장
                }
            }
        }

        System.out.println(res);    // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printCloseCardSum();    // 경계값에 가장 가까운 수 출력
    }
}
