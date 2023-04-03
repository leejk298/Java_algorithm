import java.util.*;

public class 삼각달팽이_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6)));
    }

    static class Solution {
        public int[] solution(int n) {
            int[][] arr = new int[n][n];

            int x = -1, y = 0, num = 1;
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(i % 3 == 0)  // 위 -> 아래
                        x++;
                    else if(i % 3 == 1) // 왼 -> 오
                        y++;
                    else { // 대각선
                        x--;
                        y--;
                    }

                    arr[x][y] = num++;
                }
            }

            List<Integer> list = new ArrayList<>();
            for(int[] ar : arr) {
                for(int a : ar) {
                    if(a == 0)
                        break;

                    list.add(a);
                }
            }

            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
