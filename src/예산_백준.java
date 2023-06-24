import java.util.*;
import java.io.*;

/*
4
120 110 140 150
485
 */

public class 예산_백준 {
    static int N, M;    // 크기, 예산
    static int[] arr;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        M = Integer.parseInt(bf.readLine());    // 예산
    }

    public static void BinarySearch() { // 이분 탐색

        Arrays.sort(arr);   // 오름차순 정렬, 최악의 경우를 구하기 위해

        int S = 1, E = arr[N - 1];  // 인덱스, 최선의 경우: 1, 최악의 경우
        int res = 0;    // 결과값

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            int sum = 0;    // 총 합
            for(int i : arr) {  // 배열 순회
                if (mid < i)    // 크면
                    sum += mid; // 상한가 더하고
                else    // 작거나 같으면
                    sum += i;   // 그대로 더함
            }

            if(sum <= M) {  // 기준값보다 작거나 같으면
                res = Math.max(res, mid);   // 최대값을 저장
                S = mid + 1;    // 더 커질 수 있게 시작 인덱스 갱신
            } else  // 크면
                E = mid - 1;    // 더 작아져야 하므로 끝 인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
