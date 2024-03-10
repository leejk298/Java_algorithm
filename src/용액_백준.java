import java.util.*;
import java.io.*;

/*
5
-99 -2 -1 4 98
 */

public class 용액_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        arr = new int[N];   // 입력배열 초기화

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
    }

    public static void BinarySearch() { // 이진탐색

        // 이미 오름차순 정렬로 입력배열이 주어짐
        // Arrays.sort(arr);
        int x = 0, y = 0;   // 용액
        long res = Integer.MAX_VALUE;   // 결과값
        int s = 0, e = N - 1;   // 인덱스

        while(s < e) {  // 역전이 아니면, 등호가 없는 이유: 서로 다른 용액
            long sum = arr[s] + arr[e]; // 두 용액의 합

            if(res >= Math.abs(sum)) {  // 최소값이면
                res = Math.abs(sum);    // 결과값 저장
                x = arr[s]; // 용액1
                y = arr[e]; // 용액2
            }

            if(sum < 0) // 음수이면
                s++;    // 0에 가까워져야하므로 시작 인덱스 갱신
            else    // 0이나 양수이면
                e--;    // 끝 인덱스 갱신
        }

        System.out.println(x + " " + y);    // 용액 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BinarySearch(); // 이진 탐색
    }
}
