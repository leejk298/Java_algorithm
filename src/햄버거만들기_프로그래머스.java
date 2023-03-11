import java.util.*;

public class 햄버거만들기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < ingredient.length; i++) {
                arr.add(ingredient[i]);

                if(arr.size() >= 4 &&
                        arr.get(arr.size() - 4) == 1 &&
                        arr.get(arr.size() - 3) == 2 &&
                        arr.get(arr.size() - 2) == 3 &&
                        arr.get(arr.size() - 1) == 1) {

                    answer++;

                    for(int j = 0; j < 4; j++)
                        arr.remove(arr.size() - 1);
                }
            }

            return answer;
        }
    }
}
