public class 타겟넘버_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {4, 1, 2, 1}, 4));
    }

    static class Solution {
        static int answer = 0;

        public int solution(int[] numbers, int target) {
            DFS(numbers, 0, target, 0);

            return answer;
        }

        static void DFS(int[] numbers, int depth, int target, int sum) {
            if(depth == numbers.length) {   // 마지막 노드
                if(target == sum)
                    answer++;
            } else {
                DFS(numbers, depth + 1, target, sum + numbers[depth]);  // 해당 노드 값 더하기
                DFS(numbers, depth + 1, target, sum - numbers[depth]);
            }
        }
    }
}
