import java.util.*;

public class 호텔대실_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    static class Solution {
        static int[][] time;    // 입력배열

        public static int getTime(String t) {   // 시간 가져오기

            String[] str = t.split(":");    // :을 기준으로 문자열 나누기

            int h = Integer.parseInt(str[0]);   // 시간
            int m = Integer.parseInt(str[1]);   // 분

            return h * 60 + m;  // 총 시간 리턴
        }

        public static void init(String[][] book_time) {  // 초기화

            time = new int[book_time.length][2];    // 입력배열 초기화

            for(int i = 0; i < time.length; i++) {  // 길이만큼
                time[i][0] = getTime(book_time[i][0]);  // 입실시간
                time[i][1] = getTime(book_time[i][1]) + 10; // 퇴실시간 + 청소시간
            }

            Arrays.sort(time, (o1, o2) -> { // 입실, 퇴실시간 기준으로 오름차순 정렬
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];

                return o1[0] - o2[0];
            });
        }

        public static int countHotelRoom() {    // 최소한의 방 개수

            PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐

            pq.offer(time[0][1]);   // 처음 손님 퇴실시간 저장

            for(int i = 1; i < time.length; i++) {  // 다음 손님부터 끝까지
                if(pq.peek() <= time[i][0]) // 현재와 비교하여 다음 손님의 입실시간이 더 늦으면
                    pq.poll();  // 현재 방 사용 가능하므로 꺼내기

                pq.offer(time[i][1]);   // 다음 손님 퇴실시간 저장
            }

            return pq.size();   // 방의 개수 리턴
        }

        public int solution(String[][] book_time) {

            init(book_time);    // 초기화

            return countHotelRoom();    // 최소한의 방 개수 리턴
        }
    }
}
