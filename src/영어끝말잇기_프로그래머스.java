import java.util.*;

public class 영어끝말잇기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];  // 결과 배열
            List<String> list = new ArrayList<>();  // 리스트

            list.add(words[0]); // 하나 삽입

            for(int i = 1; i < words.length; i++) { // 두 번째부터 길이만큼
                String now = words[i];  // 현재
                String last = list.get(list.size() - 1);    // 마지막

                if(!list.contains(now) && (last.charAt(last.length() - 1) == now.charAt(0))) {
                    list.add(now);
                } else {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;

                    break;
                }
            }

            return answer;
        }
    }
}
