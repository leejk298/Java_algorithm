import java.util.*;

public class 호텔방배정_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(10, new long[] {1, 3, 4, 1, 3, 1})));
    }

    static class Solution {
        Map<Long, Long> map = new HashMap<>();  // 해시맵

        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];   // 길이만큼 결과배열 생성

            for(int i = 0; i < room_number.length; i++) // 길이만큼
                answer[i] = isEmptyRoom(room_number[i]);    // 방 저장

            return answer;  // 배열 리턴
        }

        public long isEmptyRoom(long num) { // 빈방 찾기
            if(!map.containsKey(num)) { // 해당 방(키)이 없으면
                map.put(num, num + 1);  // (현재 방, 다음 빈방) 저장

                return num; // 현재 방 리턴
            }

            // 해당 방이 이미 있는 경우
            long value = map.get(num); // 다음 빈방 꺼내서
            long nextRoom = isEmptyRoom(value); // 비어있는지 확인, 재귀콜
            map.put(num, nextRoom); // 다음 탐색시 시간 줄이기 위해, 부모들(키)의 값 갱신

            return nextRoom;    // 비어있는 방 리턴
        }
    }
}
