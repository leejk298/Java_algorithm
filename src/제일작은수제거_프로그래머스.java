import java.util.Arrays;

public class 제일작은수제거_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {4, 3, 2, 1})));
    }

    static class Solution {
        public int[] solution(int[] arr) {

            if(arr.length == 1) {
                return new int[] {-1};
            }

            int[] answer = new int[arr.length - 1];
            int min = arr[0];

            for(int i = 1; i < arr.length; i++)
                min = Math.min(min, arr[i]);

            int index = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == min)
                    continue;

                answer[index++] = arr[i];
            }

            return answer;
        }
    }
}
