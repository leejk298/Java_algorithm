public class 평행_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
    }

    static class Solution {
        public double getD(int a, int b, int[][] dots) {
            return (double)(dots[b][1] - dots[a][1]) / (dots[b][0] - dots[a][0]);
        }

        public int solution(int[][] dots) {
            int k = 0;
            double d[] = new double[6];

            for(int i = 0; i < 3; i++) {
                for(int j = i + 1; j < 4; j++) {
                    d[k++] = getD(i, j, dots);
                }
            }

            for(int i = 0; i < d.length; i++) {
                for(int j = i + 1; j < d.length; j++) {
                    if(d[i] == d[j]) {
                        return 1;
                    }
                }
            }

            return 0;
        }
    }
}
