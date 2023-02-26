import java.util.*;

public class 시소짝궁_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {100, 180, 360, 100, 270}));
    }

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;    // 총 합

            Arrays.sort(weights);   // 오름차순 정렬

            int count = 0;   // 한 반복당 횟수
            for(int i = 0; i < weights.length - 1; i++) {
                if(i > 0 && weights[i] == weights[i - 1]) {
                    count--; // 같으면 중복횟수 제거
                    answer += count; // 총 합에 더해주고
                    continue;   // 다음 반복으로 넘어감, 계산 필요 x
                }

                count = 0;   // 반복당 횟수 초기화
                int j = binarySearch(weights, weights[i], i + 1, weights.length - 1);   // 검사할 최대 인덱스
                while(i < j) {
                    if(compare(weights[i], weights[j])) // 조건 만족하면
                        count++; // 카운트
                    j--;
                }

                answer += count;   // 한 반복 횟수 카운트
            }

            return answer;  // 총 합 리턴
        }

        static int binarySearch(int[] w, int num, int l, int r) {   // 이진탐색
            while(l < r) {  // 역전이 일어나지않으면
                int mid = (l + r) / 2;  // 중앙값

                if(w[mid] > num * 2)    // 최대 2배이므로
                    r = mid - 1;
                else
                    l = mid + 1;
            }

            return l;
        }

        static boolean compare(int a, int b) {  // 비교
            if(a * 1 == b || a * 4 == b * 3 || a * 3 == b * 2 || a * 2 == b)    // 최대 4가지 경우
                return true;

            return false;
        }
    }
}
