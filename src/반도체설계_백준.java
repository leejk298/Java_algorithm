import java.io.*;
import java.util.StringTokenizer;

/*
6
4 2 6 3 1 5
 */

public class 반도체설계_백준 {
    static int N;   // 크기
    static int[] arr, lis;  // 입력배열, LIS 배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        arr = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
    }

    public static void BinarySearch(int S, int E, int t) {  // 이분 탐색

        int index = E;  // 삽입할 인덱스, 최악의 경우로 생각

        while(S <= E) { // 역전이 아니면 반복
            int mid = (S + E) / 2;  // 중앙값

            if(t <= lis[mid]) { // 크거나 같으면
                index = Math.min(index, mid);   // 삽입할 인덱스 저장
                E = mid - 1;    // 큰 쪽 인덱스 갱신
            } else  // 작으면
                S = mid + 1;    // 작은 쪽 인덱스 갱신
        }

        lis[index] = t; // 삽입할 위치에 값 저장
    }

    public static void printLisLength() {   // LIS 길이 출력

        lis[0] = arr[0];    // 시작값 저장
        int index = 0;  // LIS 배열 인덱스

        for(int i = 1; i < N; i++) {    // 크기만큼
            if(lis[index] < arr[i]) // 입력배열 값이 더 크면
                lis[++index] = arr[i];  // 맞는 위치에 삽입
            else    // 작거나 같으면
                BinarySearch(0, index, arr[i]); // 이분 탐색, 맞는 위치 찾아서 삽입
        }

        System.out.println(index + 1);  // 총 길이 출력, 인덱스 0부터이므로 + 1
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printLisLength();   // LIS 길이 출력
    }
}
