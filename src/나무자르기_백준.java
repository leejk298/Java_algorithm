import java.util.*;
import java.io.*;

/*
4 7
20 15 10 17
 */

public class 나무자르기_백준 {
    static int N, M;    // 크기, 개수
    static int S, E;    // 인덱스
    static int[] arr;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());   // 자를 개수

        // 초기화
        S = 0;
        E = Integer.MIN_VALUE;  // 최악의 겨우

        // 초기화
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            E = Math.max(E, arr[i]);    // 최대 값
        }
    }

    public static void BinarySearch() { // 이진 탐색

        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값
            long h = 0; // 높이

            for(int i : arr)    // 배열 순회
                if(i > mid) // 크면
                    h += i - mid;   // 잘른 나무 높이의 총 합

            if(M <= h) {    // 자를 만큼보다 더 자르면
                S = mid + 1;    // 덜 잘라야하므로 시작 인덱스 갱신
                res = Math.max(res, mid);  // 자를 만큼만 가져가도 되므로, 최대 높이값 저장
            } else  // 덜 자르면
                E = mid - 1;    // 더 잘라야하므로 끝 인덱스 갱신
        }

        System.out.println(res);    // 최대값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
