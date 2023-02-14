import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 수를묶어서_최댓값만들기_Greedy_034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 크기

        // 우선순위 큐
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); // 양수는 내림차순
        PriorityQueue<Integer> minusPq = new PriorityQueue<>(); // 음수는 오름차순

        int one = 0;	// 1의 개수
        int zero = 0;	// 0의 개수

        for (int i = 0; i < N; i++) {	// 크기 만큼
            int data = sc.nextInt();	// 데이터 입력받아

            // 분리집합
            if (data > 1)		// 1 보다 큰 양수 집합
                plusPq.add(data);

            else if (data == 1)	// 1 인 집합
                one++;

            else if (data == 0)	// 0 인 집합
                zero++;

            else				// 음수 집합
                minusPq.add(data);
        }

        int sum = 0;	// 합

        while (plusPq.size() > 1) {	// 양수 집합의 크기가 1 보다 크면
            int x = plusPq.remove();	// 가장 큰 수
            int y = plusPq.remove();	// 그 다음 큰 수 꺼내어

            sum = sum + (x * y);	// 묶어서 합 저장
        }

        if (!plusPq.isEmpty())	// 남아 있으면
            sum = sum + plusPq.remove();	// 나머지 저장

        while (minusPq.size() > 1) {	// 음수 집합의 크기가 1 보다 크면
            int x = minusPq.remove();	// 가장 작은 수
            int y = minusPq.remove();	// 그 다음 작은 수 꺼내어

            sum = sum + (x * y);		// 묶어서 합 저장
        }

        if (!minusPq.isEmpty())	// 남아 있으면
            if (zero == 0)		// 0 이 없다면
                sum = sum + minusPq.remove();	// 그대로 꺼내어 합하고, 있으면 곱하여 없어지므로 합하지 않음

        sum += one;	// 1 인 집합 개수 더하여 합 저장

        System.out.println(sum);	// 출력
    }
}
