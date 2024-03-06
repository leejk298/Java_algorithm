import java.io.*;
import java.util.*;

/*
9
0
12345678
1
2
0
0
0
0
32
 */

public class 최소힙_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());    // 크기

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐

        StringBuilder sb = new StringBuilder(); // 결과 문자열

        for(int i = 0; i < N; i++) {    // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int num = Integer.parseInt(st.nextToken()); // 숫자

            if(num == 0) {  // 0이면
                if(!pq.isEmpty())   // 큐가 비어있지 않으면
                    sb.append(pq.poll() + "\n");    // 최소값 하나 꺼내서 결과 문자열에 저장
                else    // 비어있으면
                    sb.append(0 + "\n");    // 0 저장
            } else  // 0이 아니면
                pq.offer(num);  // 큐에 숫자 추가
        }

        System.out.print(sb);   // 결과 문자열 출력
    }
}
