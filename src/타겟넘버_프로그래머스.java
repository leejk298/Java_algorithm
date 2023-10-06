public class 타겟넘버_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4, 1, 2, 1}, 4));
    }

    static class Solution {
        static int answer = 0;  // 초기화, 전역변수로 => DFS 안에서 처리 필요

        public int solution(int[] numbers, int target) {

            DFS(numbers, 0, target, 0); // 백트래킹

            return answer;  // 결과값 리턴
        }

        static void DFS(int[] numbers, int depth, int target, int sum) {    // 백트래킹

            // 베이스케이스
            if (depth == numbers.length) {   // 마지막 노드, 깊이 + 1 이 배열의 크기가 되면
                if (target == sum)   // 조건이 맞으면
                    answer++;   // 개수 카운트

                return;
            }

            // 재귀케이스
            DFS(numbers, depth + 1, target, sum + numbers[depth]);  // 덧셈, 깊이를 인덱스로
            DFS(numbers, depth + 1, target, sum - numbers[depth]);  // 뺄셈
        }
    }
}
