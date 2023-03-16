import java.util.*;

public class 두개뽑아서더하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {2, 1, 3, 4, 1})));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> arr = new HashSet<>();

            for(int i = 0; i < numbers.length - 1; i++) {
                for(int j = i + 1; j < numbers.length; j++) {
                    arr.add(numbers[i] + numbers[j]);
                }
            }

            return arr.stream().sorted().mapToInt(i -> i).toArray();
        }
    }
}
