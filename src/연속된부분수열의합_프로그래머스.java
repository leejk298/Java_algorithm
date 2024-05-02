import java.util.*;

public class 연속된부분수열의합_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
    }

    static class Solution {
        public int[] solution(int[] sequence, int k) {

            List<int[]> list = new ArrayList<>();   // 결과리스트
            int[] sumArr = new int[sequence.length + 1];    // 합배열

            for (int i = 1; i < sumArr.length; i++)  // 크기만큼
                sumArr[i] = sumArr[i - 1] + sequence[i - 1];    // 합배열 저장

            int s = 0, e = 1;   // 인덱스

            while (e < sumArr.length) {  // 종료조건: 선형탐색
                int sum = sumArr[e] - sumArr[s];    // 구간합

                if (sum > k) // k보다 크면
                    s++;    // 시작인덱스 갱신
                else if (sum < k)   // k보다 작으면
                    e++;    // 끝인덱스 갱신
                else {  // k와 같으면
                    list.add(new int[]{s, e - 1}); // 리스트에 구간 저장, e - 1 => 구간합 특징
                    s++;    // 인덱스 갱신
                    e++;
                }
            }

            Collections.sort(list, (o1, o2) -> {    // 정렬
                return ((o1[1] - o1[0]) - (o2[1] - o2[0]));
            }); // 구간이 짧은 것을 더 앞으로 => 음수가 나오면 두 원소의 위치를 바꾸지 않고, 양수가 나오면 두 원소의 위치를 바꿔줍니다.

            return list.get(0); // 제일 짧은 구간 리턴
        }
    }
}
