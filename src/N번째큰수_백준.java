import java.util.*;
import java.io.*;

/*
5
12 7 9 15 5
13 8 11 19 6
21 10 26 31 16
48 14 28 35 25
52 20 32 41 49
 */

public class N번째큰수_백준 {
    static int N;   // 크기
    static PriorityQueue<Integer> pq;   // 우선순위 큐

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        pq = new PriorityQueue<>(Collections.reverseOrder());   // 우선순위 큐, 최대힙: 정렬 보장 x

        // 초기화
        for(int i = 0; i < N; i++) {    // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < N; j++)  // 열
                pq.add(Integer.parseInt(st.nextToken()));   // 우선순위 큐에 삽입
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        while(N-- > 1)  // N - 1번
            pq.poll();  // 삭제 연산

        System.out.println(pq.peek());  // N번째 큰 수 출력
    }
}
