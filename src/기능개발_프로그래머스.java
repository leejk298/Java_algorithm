import java.util.*;
public class 기능개발_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Integer> queue = new LinkedList<>();  // 큐

            for(int i = 0; i < progresses.length; i++) {    // 크기만큼
                int num = 100 - progresses[i];  // 숫자

                if(num % speeds[i] == 0)    // 나누어 떨어지면
                    queue.offer(num / speeds[i]);   // 개수만큼
                else    // 아니면
                    queue.offer(num / speeds[i] + 1);   // 개수 + 1
            }

            List<Integer> arr = new ArrayList<>();  // 결과리스트
            int now = queue.peek(), count = 0;  // 초기화

            while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int next = queue.poll();    // 하나 꺼내어

                if(now < next) {    // 현재 값보다 크면
                    arr.add(count); // 리스트에 추가

                    count = 0;  // 개수 초기화
                    now = next; // 현재값 갱신
                }

                count++;    // 개수 카운트
            }

            arr.add(count); // 개수 삽입

            return arr.stream().mapToInt(i -> i).toArray(); // 정수형 배열 리턴
        }
    }
}
