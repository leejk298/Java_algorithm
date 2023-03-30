import java.util.*;

public class 폰켓몬_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 3, 3, 2, 2, 4}));
    }

    static class Solution {
        public int solution(int[] nums) {
            int max = nums.length / 2;
            Set<Integer> set = new HashSet<>();

            for(int num : nums)
                set.add(num);

            if(set.size() > max)
                return max;

            return set.size();
        }
    }
}
