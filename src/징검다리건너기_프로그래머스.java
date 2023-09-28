public class 징검다리건너기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1,}, 3));
    }

    static class Solution {
        public int solution(int[] stones, int k) {

            int answer = 0;

            int min = 1, max = 200000000;   // 최소, 최대 인원수
            while(min <= max) { // 역전이 아니면
                int mid = (min + max) / 2;  // 중앙값

                if(Across(stones, k, mid)) { // 이진 탐색
                    min = mid + 1;  // 가능하면 GT 부분 탐색
                    answer = Math.max(answer, mid); // 값 저장
                } else
                    max = mid - 1;  // 불가능하면 LT 부분 탐색
            }

            return answer;  // 값 리턴
        }

        boolean Across(int[] stones, int k, int mid) {  // 이진 탐색

            int count = 0;  // 건너뛰는 칸 수
            for(int s : stones) {
                if(s - mid < 0) {   // 가능하지않으면
                    count++;    // 건너뛰도록
                    if(count == k)  // 건너뛴 칸 수가 k가 되면
                        return false;   // 불가능
                } else  // 가능하면
                    count = 0;  // 건너뛴 칸 수 초기화
            }

            return true;    // 반복문 종료되면 가능한 것이므로 true 리턴
        }
    }
}
