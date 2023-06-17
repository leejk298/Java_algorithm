import java.util.*;

/*
13
0
1
2
0
0
3
2
1
0
0
0
0
0
 */

public class 최대힙_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐, 내림차순 -> 최대힙

        for(int i = 0; i < N; i++) {    // 크기만큼
            int num = sc.nextInt(); // 숫자

            if(num == 0) {  // 0 이면
                if(pq.isEmpty())    // 우선순위 큐가 비어있으면
                    System.out.println(0);  // 0 출력
                else    // 비어있지 않으면
                    System.out.println(pq.poll());  // 최대값 -> 루트값 출력
            } else  // 0이 아니면
                pq.offer(num);  // 우선순위 큐에 추가 -> 내림차순 정렬
        }
    }
}
