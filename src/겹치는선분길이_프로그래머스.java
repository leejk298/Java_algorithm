public class 겹치는선분길이_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{0, 5}, {3, 9}, {1, 10}}));
    }

    static class Solution {
        public int solution(int[][] lines) {
            int[] arr = new int[201];
            int answer = 0;

            for(int i = 0; i < lines.length; i++)
                for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++)
                    arr[j]++;

            for(int i = 0; i < arr.length; i++)
                if(arr[i] > 1)
                    answer++;

            return answer;
        }
    }
}
