import java.util.*;

public class 줄서는방법_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, 5)));
    }

    static class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];  // 결과배열
            long[] F = new long[n + 1]; // 팩토리얼
            boolean[] visited = new boolean[n + 1]; // 방문배열

            F[0] = 1;   // 1로 초기화
            for(int i = 1; i <= n; i++)
                F[i] = F[i - 1] * i;    // 크기만큼 구해줌

            for(int i = 1; i <= n; i++) {   // 몇 번째 자리에
                for(int j = 1, flag = 1; j <= n; j++) { // 몇 번째 숫자가 들어갈 지
                    if(visited[j])  // 사용하였으면 스킵
                        continue;
                    if(k <= flag * F[n - i]) {  // 맞는 숫자 찾을때까지 flag 이용
                        k = k - (F[n - i] * (flag - 1));    // 다음 자릿수 경우의 수 갱신
                        answer[i - 1] = j;  // 결과배열에 저장
                        visited[j] = true;  // 방문배열 갱신

                        break;  // for(i)
                    }
                    // flag 갱신 => 다음자리의 경우의 수(팩토리얼)를 flag를 증가시키면서 몇 번째 숫자가 들어갈 지 체크
                    flag++;
                }
            }

            return answer;
        }
    }
}
