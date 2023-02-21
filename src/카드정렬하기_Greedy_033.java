import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기_Greedy_033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 크기

        PriorityQueue<Integer> pq = new PriorityQueue<>();	// 우선순위 큐, 분리집합 => 그리디 알고리즘

        for (int i = 0; i < N; i++) {	// 크기 만큼
            int data = sc.nextInt();	// 입력데이터
            pq.add(data);	// 우선순위 큐에 삽입
        }

        int x = 0, y = 0, sum = 0;

        while (pq.size() != 1) {	// 우선순위 큐의 크기가 1이 아니면
            x = pq.remove();	// 작은 것부터 꺼내고
            y = pq.remove();
            sum = sum + x + y;	// 더하여

            pq.add(x + y);		// 다시 우선순위 큐에 삽입
        }

        System.out.println(sum);	// 출력
    }
}
