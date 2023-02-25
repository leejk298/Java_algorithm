import java.util.*;

public class 사칙연산_DP_프로그래머스 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
    }

    static class Solution {
        static int[][] min, max;

        public int solution(String arr[]) {
            int len = arr.length / 2 + 1; // 숫자 개수
            min = new int[len][len];
            max = new int[len][len];

            int[] temp = new int[len];
            for(int i = 0; i < arr.length; i += 2) {
                int num = Integer.parseInt(arr[i]);

                if(i == 0)
                    temp[i / 2] = num;
                else
                    temp[i / 2] = arr[i - 1].equals("+") ? num : -num;
            }

            for(int i = len - 1; i >= 0; i--) {
                for(int j = i; j < len; j++) {
                    if(i == j) {
                        min[i][j] = temp[i];
                        max[i][j] = temp[i];
                    } else {
                        min[i][j] = Integer.MAX_VALUE;
                        max[i][j] = Integer.MIN_VALUE;

                        for(int k = i; k < j; k++) {
                            boolean flag = k == i ? true : false;
                            // 4가지 경우
                            findMinAndMax(min[i][k], min[k + 1][j], i, j, flag);
                            findMinAndMax(min[i][k], max[k + 1][j], i, j, flag);
                            findMinAndMax(max[i][k], min[k + 1][j], i, j, flag);
                            findMinAndMax(max[i][k], max[k + 1][j], i, j, flag);
                        }
                    }
                }
            }

            return max[0][len - 1];
        }

        public void findMinAndMax(int a, int b, int i, int j, boolean flag) {
            if(flag && a < 0) {
                min[i][j] = Math.min(min[i][j], Math.min(a - b, a + b));
                max[i][j] = Math.max(max[i][j], Math.max(a - b, a + b));
            } else {
                min[i][j] = Math.min(min[i][j], a + b);
                max[i][j] = Math.max(max[i][j], a + b);
            }
        }
    }
}
