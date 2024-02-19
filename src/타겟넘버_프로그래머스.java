public class 타겟넘버_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{4, 1, 2, 1}, 4));
    }

    static class Solution {
        static int answer;  // 결과값

        public static void DFS(int[] numbers, int depth, int target, int sum) {

            if (depth == numbers.length) {   // 베이스케이스: 깊이가 길이와 같아지면
                if (sum == target)   // 총합이 타겟넘버와 같으면
                    answer++;   // 개수 카운트

                return; // 완전 탐색하기 위해 리턴
            }

            // 재귀케이스: 깊이가 길이와 다르면
            DFS(numbers, depth + 1, target, sum + numbers[depth]);  // 재귀콜, +
            DFS(numbers, depth + 1, target, sum - numbers[depth]);  // 재귀콜, -
        }

        public int solution(int[] numbers, int target) {

            answer = 0; // 결과값 초기화

            DFS(numbers, 0, target, 0); // DFS

            return answer;  // 결과값 리턴
        }
    }
}
