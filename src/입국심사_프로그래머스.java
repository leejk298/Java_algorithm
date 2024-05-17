import java.util.Arrays;

public class 입국심사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }

    static class Solution {
        public long solution(int n, int[] times) {

            Arrays.sort(times); // 오름차순 정렬, 이분 탐색하기 위해

            long S = 0, E = (long) n * times[times.length - 1];  // 인덱스, E: 최악의 경우
            long answer = 0;    // 결과값

            while (S <= E) { // 역전이 아니면 반복
                long sum = 0, mid = (S + E) / 2;    // 합, 중앙값

                for (int t : times)  // 순회
                    sum += mid / t; // 해당 구간의 심사 가능 인원 수

                if (sum < n) // 심사 수보다 작으면
                    S = mid + 1;    // 시작 인덱스 갱신
                else {  // 크면
                    E = mid - 1;    // 끝 인덱스 갱신
                    answer = mid;   // 전부 심사했으므로 결과값 저장
                }
            }

            return answer;  // 역전이 일어나서 while 종료되면 결과값 출력
        }
    }
}
