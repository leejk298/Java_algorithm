import java.io.*;
import java.util.*;

/*
5 21
5 6 7 8 9
 */

public class 블랙잭_백준 {
    static int N, M;    // 크기
    static int[] arr;   // 입력배열

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());  // 경계값

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        arr = new int[N];   // 초기화
        for (int i = 0; i < N; i++) // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
    }

    public static void printCloseCardSum() {    // M에 가장 가까운 숫자 출력

        int sum = 0, max = 0;   // 합, 결과값

        for (int i = 0; i < N - 2; i++) {   // 첫 번째 카드
            for (int j = i + 1; j < N - 1; j++) {   // 두 번째 카드
                for (int k = j + 1; k < N; k++) {   // 세 번째 카드
                    sum = arr[i] + arr[j] + arr[k]; // 총 합

                    if(sum <= M)    // 경계값 이하이면
                        max = Math.max(max, sum);   // 최대값
                }
            }
        }

        System.out.println(max);    // 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCloseCardSum();    // 경계값에 가장 가까운 수 출력
    }
}
