import java.util.*;
import java.io.*;

/*
5 4
1 2
3 4
1 4
2 2
 */

public class 바구니뒤집기_백준 {

    public static void swap(int[] arr, int s, int e) {  // 스왑

        while(s < e) {  // 역전이 아니면
            int tmp = arr[s];   // 스왑
            arr[s++] = arr[e];
            arr[e--] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1]; // 초기화
        for(int i = 1; i <= N; i++)
            arr[i] = i;

        for(int i = 0; i < M; i++) {    // M 만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작 인덱스
            int e = Integer.parseInt(st.nextToken());   // 끝 인덱스

            swap(arr, s, e);    // 스왑 함수
        }

        for(int i = 1; i <= N; i++) // N 만큼
            System.out.print(arr[i] + " "); // 출력
    }
}
