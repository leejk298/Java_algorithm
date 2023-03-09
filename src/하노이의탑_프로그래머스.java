import java.util.*;

public class 하노이의탑_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(2)));
    }

    static class Solution {
        List<int[]> order = new ArrayList<>();

        public int[][] solution(int n) {

            hanoi(n, 1, 3, 2);

            int[][] answer = new int[order.size()][2];

            for(int i = 0; i < order.size(); i++) {
                int[] tmp = order.get(i);

                answer[i][0] = tmp[0];
                answer[i][1] = tmp[1];
            }

            return answer;
        }

        public void hanoi(int n, int from, int to, int via) {
            int[] arr = {from, to};

            if(n == 1)
                order.add(arr);
            else {
                hanoi(n - 1, from, via, to);
                order.add(arr);
                hanoi(n - 1, via, to, from);
            }
        }
    }
}
