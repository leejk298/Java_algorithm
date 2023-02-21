import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드게임_Queue_013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 입력받기

        Queue<Integer> myQueue = new LinkedList<>();	// 정수형 Queue 선언

        for (int i = 1; i <= N; i++) {	// 1부터 N까지
            myQueue.add(i);	// 큐에 삽입
        }

        while(myQueue.size() > 1) {	//	크기가 1일 때까지
            myQueue.poll();	// front 위치에서 삭제
            myQueue.add(myQueue.poll());	// 그 다음 front 위치에서 삭제된 값을 rear 위치에 삽입 => 맨 뒤로
        }

        System.out.println(myQueue.poll());	// 큐에 하나 있는 값 출력
    }
}
