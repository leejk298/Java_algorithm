import java.util.*;

public class 두큐의합같게만들기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
    }

    static class Solution {
        public int solution(int[] queue1, int[] queue2) {

            long s1 = 0, s2 = 0, sum = 0;   // 각 배열 합, 총합
            Queue<Integer> q1 = new LinkedList<>(); // 1
            Queue<Integer> q2 = new LinkedList<>(); // 2

            for(int i : queue1) {   // 1
                q1.add(i);  // 큐에 삽입
                s1 += i;    // 배열1 합
            }

            for(int i : queue2) {   // 2
                q2.add(i);
                s2 += i;
            }

            sum = s1 + s2;  // 총합
            if(sum % 2 == 1)    // 홀수
                return -1;

            sum /= 2;   // 절반
            int cnt1 = 0, cnt2 = 0, count = queue1.length * 2;  // 큐 실행횟수, 한 바퀴 횟수
            while(cnt1 <= count && cnt2 <= count) { // 유효하면
                if(s1 == sum)   // 정답
                    return cnt1 + cnt2;

                if(s1 > sum) {  // 1이 크면
                    int tmp = q1.poll();    // 하나 꺼내어

                    s1 -= tmp;  // 1은 빼고
                    s2 += tmp;  // 2는 추가
                    q2.add(tmp);    // q2에 삽입

                    cnt1++; // 1번 횟수
                } else {
                    int tmp = q2.poll();

                    s2 -= tmp;
                    s1 += tmp;
                    q1.add(tmp);

                    cnt2++;
                }
            }

            return -1;
        }
    }
}
