public class NQueen_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        static int[] arr;   // 1차 배열로 압축
        // 배열값으로 퀸의 위치
        static int answer;  // 결과

        public int solution(int n) {
            answer = 0;     // 초기화
            arr = new int[n];

            BT(0, n);   // 백트래킹

            return answer;  // 결과 리턴
        }

        public static void BT(int depth, int n) {   // 백트래킹
            if(depth == n) {    // n이 되면
                answer++;
                return;
            }

            // n이 아니면
            for(int i = 0; i < n; i++) {    // n만큼
                arr[depth] = i; // 좌표

                if(isValid(depth))  // 유효한지 체크
                    BT(depth + 1, n);   // 유효하면 다음 열로
            }
        }

        public static boolean isValid(int num) {
            for(int i = 0; i < num; i++) {  // 열
                if(arr[i] == arr[num])  // 같은 행 존재하면 x
                    return false;
                if(Math.abs(num - i) == Math.abs(arr[num] - arr[i])) // 대각선
                    return false;
            }

            return true;
        }
    }
}
