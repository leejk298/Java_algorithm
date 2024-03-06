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
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐, 내림차순 정렬

        for (int i = 0; i < N; i++) {   // 크기
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < N; j++) {   // 크기
                int num = Integer.parseInt(st.nextToken()); // 숫자

                pq.offer(num);  // 우선순위 큐에 삽입
            }
        }

        for (int i = 1; i < N; i++) // N - 1 만큼
            pq.poll();  // 우선순위 큐에서 삭제

        System.out.println(pq.peek());  // N번째 큰 수 출력
    }
}