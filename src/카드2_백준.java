import java.util.*;
import java.io.*;

/*
6
 */

public class 카드2_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        Queue<Integer> queue = new LinkedList<>();  // 큐

        for (int i = 1; i <= N; i++)    // 크기만큼
            queue.offer(i); // 큐에 삽입

        while (queue.size() > 1) {  // 큐에 한 장 남을 때까지
            queue.poll();   // front 위치에 있는 숫자 제거
            queue.offer(queue.poll());  // 그 다음 숫자는 꺼내서 rear 위치로 삽입
        }

        System.out.println(queue.poll());   // 마지막 남은 한 장 출력
    }
}
