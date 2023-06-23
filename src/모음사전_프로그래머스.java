import java.util.*;

public class 모음사전_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("EIO"));
    }

    static class Solution {
        public int solution(String word) {

            String str = "AEIOU";   // 기준 문자열
            int[] order = {781, 156, 31, 6, 1}; // 자리수가 해당 인덱스만큼 커짐

            int answer = word.length(); // 길이로 초기화
            for(int i = 0; i < word.length(); i++){ // 길이만큼
                int index = str.indexOf(word.charAt(i));    // 기준 문자열에서 어디 인덱스인지
                answer += order[i] * index; // 인덱스에 해당하는 자리수만큼 곱해서 더해줌
            }

            return answer;  // 결과값 리턴
        }
    }
}
