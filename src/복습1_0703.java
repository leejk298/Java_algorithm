import java.util.*;

/*
"2014-10-24 12:33:00
2014-10-24 13:33:00
2014-10-24 14:33:00
2014-10-24 15:33:00
2014-10-24 16:33:00"
 */

public class 복습1_0703 {

    public static int[] solution(String logs){

        int[] answer = new int[24]; // 결과배열, 0 ~ 23 시간

        String[] log = logs.split("\n");    // 개행문자 기준

        for(String str : log) { // 배열 순회
            String[] st = str.split(" ");   // 공백 기준
            String[] time = st[1].split(":");   // : 기준
            String hour = time[0];  // 시간

            int h = Integer.parseInt(hour) + 9; // +9 => 한국시간
            h %= 24;    // 한국시간으로 24시가 넘어갈 수도 있으므로 예외 처리

            answer[h]++;    // 해당 인덱스에 저장
        }

        return answer;  // 결과배열 리턴
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String("2014-10-24 12:33:00\n2014-10-24 13:33:00\n2014-10-24 14:33:00\n2014-10-24 15:33:00\n2014-10-24 16:33:00"))));
    }
}
