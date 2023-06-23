import java.util.*;
import java.io.*;

/*
4 11
802
743
457
539
 */

public class 랜선자르기_백준 {
    static int N, K;    // 크기, 잘라야하는 개수
    static long S, E;   // 인덱스
    static long[] arr;  // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        K = Integer.parseInt(st.nextToken());   // 개수

        // 인덱스 초기화
        S = 1;  // 길이가 1부터이므로 최소 1
        E = Integer.MIN_VALUE;  // 최대 길이구해야하므로, 최소값으로 초기화

        // 초기화
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(bf.readLine());
            E = Math.max(E, arr[i]);    // 최악의 경우 구하기
        }
    }

    public static void BinarySearch() {   // 이분 탐색

        long res = 0;   // 결과값

        while (S <= E) {    // 역전이 아니면 반복
            long mid = (S + E) / 2; // 중앙값
            int count = 0;  // 개수

            for (long i : arr)  // 배열 순회
                count += i / mid;   // 잘린 개수 카운트

            if (K <= count) {   // 자를 개수보다 큰 경우, 덜 잘라야하므로
                S = mid + 1;    // 시작 인덱스 갱신
                res = Math.max(res, mid);   // 다 자르긴 했으므로 최대값 저장
            } else if (K > count)   // 작은 경우, 더 잘라야하므로
                E = mid - 1;    // 끝 인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BinarySearch();   // 최대 길이 출력
    }
}
