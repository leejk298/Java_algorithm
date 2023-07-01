import java.util.*;

public class 복습3_0701 {
    static Map<Integer, Integer> count; // 당첨 전 구매 횟수
    static Map<Integer, Integer> check; // 당첨 여부, 0 - false, 1 - true
    static int answer;  // 결과값

    public static void init(int[][] lottery) {  // 초기화

        // 초기화
        answer= 0;
        count = new HashMap<>();
        check = new HashMap<>();

        for(int i = 0; i < lottery.length; i++) {   // 입력배열 크기만큼
            int id = lottery[i][0], flag = lottery[i][1];   // id, 당첨 여부

            // 당첨이 아니면 => 당첨 전까지만 개수 카운트
            if(flag == 0 && !check.containsKey(id)) // 꽝 개수 카운트
                count.put(id, count.getOrDefault(id, 0) + 1);   // 해시맵 저장

            // 당첨이면
            if(flag == 1)
                check.put(id, flag);    // 해시맵 저장
        }
    }

    public static void findAvgCount() { // 평균 구매 횟수

        // 총 몇 명 당첨 + id
        int cnt = 0, sum = 0;

        for(int id : check.keySet()) {  // 당첨 여부 해시맵 순회
            if(check.get(id) == 1) {    // 당첨된 사람이면
                cnt++;  // 몇 명인 지 카운트

                // 해당 사람이 몇 번 시도만에 당첨되었는지
                if(count.containsKey(id))   // 키가 존재하면 여러 번 시도만에 당첨이므로
                    sum += count.get(id);   // 총 합에 더해줌

                /**
               * 틀린점 => 한 번에 당첨된 경우에는 밑에서 수행함
               */
//                else          // 키가 없으면 한 번에 당첨이므로
//                    sum++;    // 한 번만 더해줌
            }
        }

        if(cnt != 0)    // 당첨자가 있으면
            answer = (sum + cnt) / cnt;
        /**
         * (sum + cnt) => 처음 당첨될 때까지의 횟수 계산이므로
                          여기서 한 번에 당첨한 경우도 들어감
         */
    }

    public static int solution(int[][] lottery) {

        init(lottery);  // 초기화

        findAvgCount(); // 당첨자 평균 몇 번 구매

        return answer;  // 결과값 리턴
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[][] {{1, 0}, {2, 0}, {3, 1}}));
    }
}
