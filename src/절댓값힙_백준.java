import java.util.*;

/*
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
 */

public class 절댓값힙_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기

        // 우선순위 큐 정렬 기준 커스터마이징
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int x = Math.abs(o1);
            int y = Math.abs(o2);

            // return 값이 음수나 0 이면 내림차순
            // return 값이 양수면 오름차순

            // 절댓값이 같을 때 -> 음수 우선
            if (x == y)
                return o1 > o2 ? 1 : -1;
                // 절댓값이 다를 때 -> 작은 수 우선
            else
                return x - y;
        });

        for (int i = 0; i < N; i++) { // N 만큼
            int req = sc.nextInt(); // 한 줄 스트링 정수로 파싱

            if (req == 0) // 0 이면
            {
                if (myQueue.isEmpty()) // 큐가 비어있으면
                    System.out.println("0"); // 0 출력
                else // 비어있지 않으면
                    System.out.println(myQueue.poll()); // 큐의 front 위치의 값 (절대값 힙 - 루트 값) 출력
            }

            else // 0이 아니면
                myQueue.add(req); // 큐의 rear 위치에 삽입
        }
    }
}
