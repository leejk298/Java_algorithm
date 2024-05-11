import java.util.*;

public class 외톨이알파벳_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("edeaaabbccd"));
    }

    static class Solution {
        public String solution(String input_string) {

            Map<Character, Boolean> hashMap = new HashMap<>();  // 해시맵
            Set<Character> set = new HashSet<>();   // 해시셋

            char current = ' '; // 현재 문자

            for (char ch : input_string.toCharArray()) { // 입력문자열에서 문자 하나씩
                if (ch != current) { // 현재 문자와 다르면
                    if (hashMap.containsKey(ch)) // 해시맵에 키가 존재하면 => 두 번 나오면
                        set.add(ch);    // 해시셋에 저장

                    hashMap.put(ch, true);  // 해시맵에 저장
                    current = ch;   // 현재 문자 갱신
                }
            }

            if (set.size() == 0) // 해시셋 크기가 0이면
                return "N"; // 문자열 N 리턴

            List<Character> list = new ArrayList<>(set);    // 리스트, 해시셋 정렬하기 위해
            Collections.sort(list); // 오름차순 정렬

            String answer = ""; // 결과 문자열

            for (char c : list)  // 리스트에서 문자 하나씩
                answer += c;    // 결과 문자열에 이어붙이기

            return answer;  // 결과 문자열 리턴
        }
    }
}
