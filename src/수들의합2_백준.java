import java.util.*;
import java.io.*;

/*
10 5
1 2 3 4 2 5 3 1 1 2
 */

public class 수들의합2_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        int M = Integer.parseInt(st.nextToken());   // 합

        int[] arr = new int[N]; // 초기화, 입력배열

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장

        int sum = 0, S = 0, E = 0, count = 0;   // 구간합, 인덱스, 개수

        while(S < N) {  // 시작인덱스가 유효하면
            if(sum > M || E == N) { // 구간합이 더 크거나 끝 인덱스가 도착하면 작아져야하므로
                sum -= arr[S];  // 시작 인덱스의 값 빼줌
                S++;    // 시작 인덱스 이동
            } else {    // 합이 더 크고 끝 인덱스가 도착하지 않으면 커져야하므로
                sum += arr[E];  // 끝 인덱스의 값 더해줌
                E++;    // 끝 인덱스 이동
            }

            // 연산 결과가 같으면
            if(sum == M)
                count++;    // 개수 카운트
        }

        System.out.println(count);  // 총 개수 출력
    }
}
