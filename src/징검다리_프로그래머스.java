import java.util.*;

public class 징검다리_프로그래머스 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(25, new int[] {2, 14, 11, 21, 17}, 2));
    }

    static class Solution {
        public int removeRocks(int distance, int[] rocks, int mid) {

            int before = 0, end = distance, remove = 0; // 이 전 거리, 끝 거리, 제거 개수

            for(int r : rocks) {    // 배열 순회하여
                if(r - before < mid) {  // 차이가 중앙값보다 작으면
                    remove++;   // 제거

                    continue;   // 다시 for 반복
                }

                // 크거나 같으면
                before = r; // 이전 값 갱신
            }

            if(end - before < mid)  // 마지막 끝 거리와의 차이가 중앙값보다 작으면
                remove++;   // 제거

            return remove;  // 제거 개수 리턴
        }

        public int solution(int distance, int[] rocks, int n) {

            int answer = 0; // 결과값

            Arrays.sort(rocks); // 오름차순 정렬, 이분 탐색하기 위해

            int S = 1, E = distance;    // 인덱스 설정, E: 최악의 경우

            while(S <= E) { // 역전이 아니면 반복
                int mid = (S + E) / 2;  // 중앙값

                if(removeRocks(distance, rocks, mid) <= n) {    // 제거한 바위 개수가 제거할 개수보다 작거나 같으면
                    S = mid + 1;    // 시작 인덱스 갱신
                    answer = mid;   // 조건에 만족하므로 결과값 저장
                } else  // 크면
                    E = mid - 1;    // 끝 인덱스 갱신
            }

            return answer;  // 역전이 일어나서 while 종료되면 결과값 출력
        }
    }
}
