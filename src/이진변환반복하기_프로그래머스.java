import java.util.Arrays;

public class 이진변환반복하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("110010101001")));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            int count1 = 0, count0 = 0, i = 0;
            while (!s.equals("1")) {
                char[] ch = s.toCharArray();
                count1 = 0;

                for(char c : ch) {
                    if(c == '1')
                        count1++;
                    else
                        count0++;
                }

                i++;
                s = Integer.toBinaryString(count1);
            }

            answer[0] = i;
            answer[1] = count0;

            return answer;
        }
    }
}
