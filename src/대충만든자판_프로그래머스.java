import java.util.*;

public class 대충만든자판_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"})));
    }

    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {

            int[] answer = new int[targets.length]; // 결과배열, 크기: 찾을 문자열 개수만큼
            Map<Character, Integer> hashMap = new HashMap<>();  // 해시맵

            for(String k : keymap) {    // 주어진 입력 문자열 개수만큼
                for(int i = 0; i < k.length(); i++) {   // 문자열 길이만큼
                    char key = k.charAt(i); // 문자 하나씩

                    if(!hashMap.containsKey(key) || i < hashMap.get(key)) { // 포함되어있지 않거나 포함되어있으면 더 작은 밸류 값으로
                        hashMap.put(key, i + 1);    // 해시맵에 저장
                    }
                }
            }

            for(int i = 0; i < targets.length; i++) {   // 찾을 문자열 개수만큼
                int count = 0;  // 개수
                boolean isPresent = true;   // 존재하는지

                for(char ch : targets[i].toCharArray()) {   // 문자열 크기만큼, 문자 하나씩 비교
                    if(hashMap.containsKey(ch)) {   // 해시맵에 존재하면
                        count += hashMap.get(ch);   // 밸류값 더 해줌
                    } else {    // 존재하지 않으면
                        isPresent = false;  // false

                        break;  // for 종료
                    }
                }

                if(isPresent)   // 존재하면
                    answer[i] = count;  // 개수 저장
                else    // 존재하지 않으면
                    answer[i] = -1; // -1 저장
            }

            return answer;  // 결과배열 저장
        }
    }
}
