import java.util.*;

public class 호텔대실_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    static class Solution {
        static int[][] time;    // 입력배열
        public int getTime(String s) {  // 시간 얻기

            String[] tmp = s.split(":");    // : 기준으로 나눔

            int h = Integer.parseInt(tmp[0]);   // 시간
            int m = Integer.parseInt(tmp[1]);   // 분

            return h * 60 + m;  // 총 시간 리턴
        }

        public void init(String[][] book_time) {    // 초기화
            time = new int[book_time.length][2];    // 입력배열

            for(int i = 0; i < book_time.length; i++) { // 크기만큼
                time[i][0] = getTime(book_time[i][0]);   // 시작
                time[i][1] = getTime(book_time[i][1]) + 10;    // 끝 + 10분(청소)
            }

            Arrays.sort(time, (o1, o2) -> { // 정렬
                if(o1[0] == o2[0])  // 시작시간이 같으면
                    return o1[1] - o2[1];   // 종료시간이 빠른 순으로 오름차순 정렬

                return o1[0] - o2[0];   // 다르면 시작시간이 빠른 순으로 오름차순 정렬
            });
        }

        public static int countHotel() {    // 호텔 객실 개수

            PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐

            pq.offer(time[0][1]);   // 가장 우선순위인 객실 하나 배정

            for(int i = 1; i < time.length; i++) {  // N - 1 만큼
                if((pq.peek()) <= time[i][0]){  // 이전 객실 종료시간보다 현재 객실 시작시간이 크거나 같으면
                    pq.poll();  // 이전 객실 종료
                    pq.add(time[i][1]); // 현재 객실 삽입
                }else   // 작으면
                    pq.add(time[i][1]); // 객실 하나 더 배정
            }

            return pq.size();   // 객실 개수 리턴
        }

        public int solution(String[][] book_time) {

            init(book_time);    // 초기화

            return countHotel();    // 객실 개수 리턴
        }
    }
}
