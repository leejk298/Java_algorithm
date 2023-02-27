import java.util.*;

public class 신고결과받기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));

    }

    static class Solution {
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            // Hash 초기화
            for(int i = 0; i < id_list.length; i++) {
                HashSet<String> reportId = new HashSet<>();
                reportMap.put(id_list[i], reportId);
                answerMap.put(id_list[i], 0);
            }

            // 값 세팅
            for(String str : report) {
                String[] tmp = str.split(" ");
                reportMap.get(tmp[1]).add(tmp[0]);
            }

            // 처리
            for(String str : reportMap.keySet()) {
                HashSet<String> rId = reportMap.get(str);

                if(rId.size() >= k) {
                    for(String id : rId)
                        answerMap.put(id, answerMap.get(id) + 1);
                }
            }

            // copy
            for(int i = 0; i < id_list.length; i++)
                answer[i] = answerMap.get(id_list[i]);

            return answer;
        }
    }
}
