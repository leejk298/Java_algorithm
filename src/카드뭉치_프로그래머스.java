import java.util.*;

public class 카드뭉치_프로그래머스 {

    static class Solution {

        public String solution(String[] cards1, String[] cards2, String[] goal) {

            Queue<String> queue1 = new LinkedList<>();  // 큐1
            Queue<String> queue2 = new LinkedList<>();  // 큐2

            for (String card : cards1)  // 큐1 저장
                queue1.offer(card);

            for (String card : cards2)  // 큐2 저장
                queue2.offer(card);

            for (String str : goal) {   // 입력 문자열 순회
                if (!queue1.isEmpty() && queue1.peek().equals(str)) // 큐1이 비어있지 않고 입력 문자열과 큐1의 front 값이 같으면
                    queue1.poll();  // 큐1 front 값 하나 꺼내기
                else if (!queue2.isEmpty() && queue2.peek().equals(str))
                    queue2.poll();
                else    // 큐1, 큐2 둘 다 없으면
                    return "No";    // No 리턴
            }

            return "Yes";   // 전부 다 나왔으므로 Yes 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}));
    }
}
