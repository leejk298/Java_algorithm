import java.util.*;

public class 소수만들기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 2, 7, 6, 4}));
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < nums.length - 2; i++)
                for(int j = i + 1; j < nums.length; j++)
                    for(int k = j + 1; k < nums.length; k++)
                        arr.add(nums[i] + nums[j] + nums[k]);

            for(int n : arr) {
                for(int i = 2; i <= Math.sqrt(n); i++) {
                    if(n % i == 0) {
                        answer--;
                        break;
                    }
                }

                answer++;
            }

            return answer;
        }
    }
}
