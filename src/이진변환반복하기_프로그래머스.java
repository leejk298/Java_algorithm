import java.util.Arrays;

public class 이진변환반복하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("110010101001")));
    }

    static class Solution {
        public String convertBinaryString(int num) {    // 이진변환

            String s = "";

            while (num != 0) {  // 0이 아니면 반복
                s += num % 2;   // 나머지
                num /= 2;   // 몫
            }

            return s;   // 리턴
        }

        public int[] solution(String s) {

            int[] answer = new int[2];  // 결과값

            int count = 0, remove = 0;  // 반복횟수, 제거된 0의 개수
            while (!s.equals("1")) { // 1이 아니면 반복
                int length = 0; // 1만 있는 문자열의 길이

                for (char ch : s.toCharArray()) {   // 문자열 순회
                    if (ch == '0') // 1. 0 제거
                        remove++;
                    else    // 2. 길이를 2진법으로 표현
                        length++;
                }

                s = convertBinaryString(length);    // 이진변환
                count++;    // 반복횟수 카운트
            }

            answer[0] = count;  // 반복횟수
            answer[1] = remove; // 제거된 0의 개수

            return answer;  // 결과값 리턴
        }
    }
}