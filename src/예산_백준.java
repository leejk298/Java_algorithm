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
        StringTokenizer st = new StringTokenizer(bf.readLine());     // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        arr = new int[N];   // 입력배열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        M = Integer.parseInt(st.nextToken());   // 예산
    }

    public static void BinarySearch() { // 이분탐색

        Arrays.sort(arr);   // 오름차순 정렬

        int s = 1, e = arr[N - 1], res = 0; // 인덱스, 결과값
        while(s <= e) { // 역전이 아니면
            int mid = (s + e) / 2;  // 중앙값

            int sum = 0;    // 총 합
            for(int num : arr) {    // 입력배열 순회
                if(mid < num)   // 중앙값보다 크면
                    sum += mid; // 중앙값을 더해주고
                else    // 아니면
                    sum += num; // 해당값을 더해줌
            }

            if(sum <= M) {  // 총 합이 예산보다 작거나 같으면
                res = Math.max(res, mid);   // 중앙값 중 최대값 저장
                s = mid + 1;    // 시작인덱스 갱신
            } else  // 아니면
                e = mid - 1;    // 끝인덱스 갱신
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BinarySearch(); // 이분 탐색
    }
}
