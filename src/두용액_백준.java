import java.io.*;
import java.util.*;

/*
5
-2 4 -99 -1 98
 */

public class 두용액_백준 {
    static int N;   // 크기
    static int[] arr;   // 입력배열
    static int res; // 결과값

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        // 초기화
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = 2000000000;   // 최대값, 1,000,000,000
    }

    public static void printTwoSolution() { // 합이 0에 가까운 두 용액 출력

        Arrays.sort(arr);   // 오름차순 정렬

        int l = 0, r = N - 1;   // 투포인터
        int index1 = -1, index2 = -1;   // 인덱스
        int sum = 0;    // 합

        while(l < r) {  // 역전이 아니면 반복
            sum = arr[l] + arr[r];  // 합

            if(res > Math.abs(sum)) {   // 절대값이 더 작으면 => 0에 가까움
                res = Math.abs(sum);    // 최소값 갱신
                index1 = l; // 인덱스1
                index2 = r; // 인덱스2

                if(res == 0)    // 0 이면 더 탐색할 필요 x
                    break;  // while 종료
            }

            if(sum > 0) // 합이 0보다 크면
                r--;    // 더 커지면 안되므로 r 줄임
            else    // 합이 0이하이명
                l++;    // 더 커져야 하므로 l 키움
        }

        System.out.println(arr[index1] + " " + arr[index2]);    // 두 용액 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printTwoSolution(); // 합이 0에 가까운 두 용액 값 출력
    }
}
