import java.util.*;

public class 연속된부분수열의합_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5)));
    }

    static class Solution {
        private static List<int[]> list;    // 결과 리스트
        public int[] solution(int[] sequence, int k) {
            list = new ArrayList<>();

            int[] sum = new int[sequence.length + 1];   // 합배열

            for(int i = 1; i < sum.length; i++)     // 누적합
                sum[i] = sum[i - 1] + sequence[i - 1];

            int i = 0, j = 1;   // 투포인터
            while(j != sum.length) {    // 끝까지
                int num = sum[j] - sum[i];  // 구간합

                if(num < k)
                    j++;
                else if(num > k)
                    i++;
                else { // 같으면
                    list.add(new int[] {i, j - 1}); // 리스트에 추가
                    i++;
                    j++;
                }
            }

            Collections.sort(list, (o1, o2) -> {    // 정렬
                if((o1[1] - o1[0]) >= (o2[1] - o2[0]))  // 구간이 짧은 순
                    return 1;
                else
                    return -1;
            });

            return list.get(0); // 가장 짧은 구간 출력
        }
    }
}
