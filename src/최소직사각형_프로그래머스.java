import java.util.*;

public class 최소직사각형_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;
            List<Integer> maxList = new ArrayList<>();
            List<Integer> minList = new ArrayList<>();

            for(int[] arr : sizes) {
                if(arr[0] > arr[1]) {
                    maxList.add(arr[0]);
                    minList.add(arr[1]);
                } else {
                    maxList.add(arr[1]);
                    minList.add(arr[0]);
                }
            }

            Collections.sort(maxList, Collections.reverseOrder());
            Collections.sort(minList, Collections.reverseOrder());

            answer = maxList.get(0) * minList.get(0);

            return answer;
        }
    }
}
