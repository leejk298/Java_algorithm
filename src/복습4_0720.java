import java.util.*;

public class 복습4_0720 {
    static int N, max;  // 크기, 결과값
    static int[] arr;   // 입력배열
    static Queue<Integer> queue;    // 큐

    public static void init(String road, int n) {   // 초기화

        N = n;  // 크기
        max = 0;    // 결과값

        // 초기화
        queue = new LinkedList<>();
        arr = new int[road.length()];

        for (int i = 0; i < road.length(); i++) {   // 길이만큼
            arr[i] = road.charAt(i) - '0';  // 입력배열 저장

            if (arr[i] == 0)    // 0 이면
                queue.offer(i); // 큐에 저장
        }
    }

    public static void findMaxCount() { // 최대개수 찾기

        int S = 0, sum = 0, chance = N; // 인덱스, 총 합, 찬스

        while (S < arr.length) {    // 유효한 인덱스인 동안
            if (arr[S] == 1)    // 1 이면
                sum++;  // 합 증가
            else if (chance != 0) { // 0 이면서 찬스가 0개가 아니면
                chance--;   // 찬스 한 개 줄이고
                sum++;  // 합 증가
            } else {    // 0 이면서 찬스가 0개 이면
                int E = queue.poll();   // 큐에서 하나 꺼내어
                sum = S - E;    // 총 합 갱신
            }

            max = Math.max(max, sum);   // 최대값 저장
            S++;    // 인덱스 증가
        }
    }

    public static int solution(String road, int n) {

        init(road, n);  // 초기화

        findMaxCount(); // 최대개수 찾기

        return max; // 최대값 출력
    }

    public static void main(String[] args) {

        System.out.println(solution("11011100111111010101", 2));
    }
}
