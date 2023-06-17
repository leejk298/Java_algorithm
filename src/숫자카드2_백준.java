import java.io.*;
import java.util.*;

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */

public class 숫자카드2_백준 {

    public static int lower(int[] arr, int t) { // 하한선

        int S = 0, E = arr.length;  // 인덱스

        while(S < E) {  // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(t <= arr[mid])   // 작거나 같으면
                E = mid;    // 끝 인덱스 갱신
            else    // 크면
                S = mid + 1;    // 시작 인덱스 갱신
        }

        return E;   // 역전이 일어났으므로 끝 인덱스 리턴
    }

    public static int higher(int[] arr, int t) {    // 상한선

        int S = 0, E = arr.length;

        while(S < E) {
            int mid = (S + E) / 2;

            if(t < arr[mid])    // 작으면
                E = mid;
            else
                S = mid + 1;
        }

        return E;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        // 초기화
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);   // 이분 탐색을 위한 정렬

        int M = Integer.parseInt(bf.readLine());    // 크기
        StringBuilder sb = new StringBuilder(); // 문자열 만들기

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < M; i++) {    // 크기만큼
            int target = Integer.parseInt(st.nextToken());  // 찾을 수
            int low = lower(arr, target);   // 하한선
            int high = higher(arr, target); // 상한선

            sb.append(high - low).append(" ");  // 차이
        }

        System.out.println(sb.toString());  // 결과 출력
    }
}
