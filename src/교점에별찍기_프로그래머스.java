import java.util.*;

public class 교점에별찍기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }

    static class Solution {
        public static int startX = Integer.MAX_VALUE;
        public static int endX = Integer.MIN_VALUE;
        public static int startY = Integer.MAX_VALUE;
        public static int endY = Integer.MIN_VALUE;

        public String[] solution(int[][] line) {
            List<List<Integer>> list = new ArrayList<>();

            for(int i = 0; i < line.length - 1; i++) {
                for(int j = i + 1; j < line.length; j++) {
                    long a = line[i][0];
                    long b = line[i][1];
                    long e = line[i][2];
                    long c = line[j][0];
                    long d = line[j][1];
                    long f = line[j][2];

                    long denominator = (a * d) - (b * c);
                    if(denominator == 0)
                        continue;

                    long numerator1 = (b * f) - (e * d);
                    long numerator2 = (e * c) - (a * f);
                    if(numerator1 % denominator != 0 || numerator2 % denominator != 0)
                        continue;

                    int x = (int)(numerator1 / denominator);
                    int y = (int)(numerator2 / denominator);
                    List<Integer> tmp = Arrays.asList(x, y);
                    if(!list.contains(tmp))
                        list.add(tmp);

                    startX = Math.min(startX, x);
                    endX = Math.max(endX, x);
                    startY = Math.min(startY, y);
                    endY = Math.max(endY, y);
                }
            }

            List<String> board = new ArrayList<>();
            for(int i = startY; i <= endY; i++) {
                StringBuilder sb = new StringBuilder();

                for(int j = startX; j <= endX; j++) {
                    sb.append(".");
                }

                board.add(sb.toString());
            }

            for(List<Integer> l : list) {
                StringBuilder sb = new StringBuilder(board.get(Math.abs(l.get(1) - endY)));
                sb.setCharAt(Math.abs(l.get(0) - startX), '*');
                board.set(Math.abs(l.get(1) - endY), sb.toString());
            }

            String[] answer = new String[board.size()];
            for(int i = 0; i < answer.length; i++)
                answer[i] = board.get(i);

            return answer;
        }
    }
}
