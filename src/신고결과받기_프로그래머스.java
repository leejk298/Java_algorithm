import java.util.*;

public class 신고결과받기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));

    }

    static class Solution {
        Map<String, HashSet<String>> reportMap;   // 신고맵
        Map<String, Integer> answerMap;   // 결과맵

        public int[] solution(String[] id_list, String[] report, int k) {

            int[] answer = new int[id_list.length]; // 결과배열 초기화
            reportMap = new HashMap<>();    // 신고맵
            answerMap = new HashMap<>();    // 결과맵

            for (int i = 0; i < id_list.length; i++) {   // 해시맵 구현
                HashSet<String> reportId = new HashSet<>(); // 집합 초기화

                reportMap.put(id_list[i], reportId);    // 신고맵 저장
                answerMap.put(id_list[i], 0);   // 결과맵 저장
            }

            for (String str : report) {  // 입력배열 순회
                String[] tmp = str.split(" ");  // 공백 기준으로 문자열 나누기
                reportMap.get(tmp[1]).add(tmp[0]);  // 값 세팅
            }

            for (String str : reportMap.keySet()) {  // 신고맵 키값 순회
                HashSet<String> rId = reportMap.get(str);   // 키값에 해당하는 밸류값

                if (rId.size() >= k)   // k 이상이면
                    for (String id : rId)    // 밸류값 순회
                        answerMap.put(id, answerMap.get(id) + 1);   // 결과맵 갱신
            }

            for (int i = 0; i < id_list.length; i++) // 길이만큼
                answer[i] = answerMap.get(id_list[i]);  // 결과배열 저장

            return answer;  // 결과배열 리턴
        }
    }
}
