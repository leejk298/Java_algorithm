import java.util.*;

public class 같은숫자는싫어_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
    }

    static class Solution {
        public int[] solution(int []arr) {
            List<Integer> list = new ArrayList<>();

            int num = -1;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != num) {
                    list.add(arr[i]);
                    num = arr[i];
                }
            }

            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
