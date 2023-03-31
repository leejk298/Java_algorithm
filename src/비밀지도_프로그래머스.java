import java.util.Arrays;

public class 비밀지도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(5, new int[] {9, 20, 28, 18, 11},
                new int[] {30, 1, 21, 17, 28})));
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for(int i = 0; i < n; i++) {
                answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
                answer[i] = answer[i].replace('0', ' ');
                answer[i] = answer[i].replace('1', '#');

                while(answer[i].length() < n) {
                    answer[i] = ' ' + answer[i];
                }
            }

            return answer;
        }
    }
}
