public class 최고의집합_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 9));
    }

    static class Solution {
        public int[] solution(int n, int s) {

            int[] answer = new int[n];  // 크기: n

            if (n > s)   // 존재 x
                return new int[]{-1};   // -1 리턴

            int i = 0, N = n;  // 인덱스, copy

            while (i < N) {  // 크기만큼
                int num = s / n;   // 자연스럽게 오름차순

                answer[i++] = num;  // 결과배열 저장

                s -= num;   // 합 갱신
                n--;    // 개수 갱신
            }

            return answer; // 결과배열 리턴
        }
    }
}
