import java.util.*;

public class 붕대감기_프로그래머스 {
    static class Solution {

        public int solution(int[] bandage, int health, int[][] attacks) {

            int end = attacks[attacks.length - 1][0];   // 종료시간
            int c = 0, h = health;  // 연속, 현재 체력

            Queue<int[]> queue = new LinkedList<>();    // 큐
            for(int i = 0; i < attacks.length; i++) // 길이만큼
                queue.offer(attacks[i]);    // 큐에 삽입

            for(int i = 1; i <= end; i++) { // 1부터 종료까지
                int[] tmp = queue.peek();   // top 위치의 값

                if(i == tmp[0]) {   // 공격 당했을 때
                    c = 0;  // 연속 시간 초기화
                    int[] now = queue.poll();   // 꺼내기

                    h -= now[1];    // 현재 체력 갱신
                    if(h <= 0) {    // 0 이하이면
                        return -1;   // -1 리턴
                    }
                } else {    // 공격 당하지 않았을 때
                    h += bandage[1];    // 회복
                    c++;    // 연속 시간 증가

                    if(c == bandage[0]) {   // 시전시간과 같아지면
                        h += bandage[2];    // 추가 체력 회복
                        c = 0;  // 연속 시간 초기화
                    }

                    if(h >= health) // 최대 체력을 넘어가면
                        h = health; // 최대값으로 초기화
                }
            }

            return h;   // 현재 체력 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 1, 5}, 30,
                new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
    }
}
