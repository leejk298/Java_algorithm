import java.util.*;
import java.io.*;

/*
7
1
5
2
10
-99
7
5
 */

public class 가운데를말해요_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙 - 오름차순 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   // 최대힙 - 내림차순 정렬

        StringBuilder sb = new StringBuilder(); // 결과문자열

        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int num = Integer.parseInt(st.nextToken()); // 숫자

            if (minHeap.size() == maxHeap.size())   // 같으면 => 0, 2, 4번 째 순으로
                maxHeap.offer(num); // 최대힙에 추가
            else    // 다르면 => 홀수이면
                minHeap.offer(num); // 최소힙에 추가

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) { // 둘 다 비어있지 않고
                if (maxHeap.peek() > minHeap.peek()) {  // 최대힙 top 값이 더 크면
                    int tmp = maxHeap.poll();   // 스왑 => 최대힙의 top 위치로 중앙값이 오도록
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }

            sb.append(maxHeap.peek() + "\n");   // 결과문자열에 최대힙 top 값 추가
        }

        System.out.print(sb);   // 결과문자열 출력
    }
}
