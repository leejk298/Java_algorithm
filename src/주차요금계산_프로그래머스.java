import java.util.*;

public class 주차요금계산_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {1, 461, 1, 10},
                new String[] {"00:00 1234 IN"})));
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {

            Map<String, Integer> parkMap = new HashMap<>(); // 주차
            Map<String, Integer> feeMap = new HashMap<>();  // 요금

            for(String str : records) {  // 차 정보
                String[] strArr = str.split(" ");   // 공백기준 문자열 배열
                String s = strArr[0];   // 시간
                String[] t = s.split(":");

                int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                if(strArr[2].equals("IN")) {    // IN
                    parkMap.put(strArr[1], time);   // (차량, 시간) 저장
                } else {    // OUT
                    int difTime = time - parkMap.get(strArr[1]);    // 시간 차이
                    feeMap.put(strArr[1], feeMap.getOrDefault(strArr[1], 0) + difTime); // (차량, 시간 차이) 저장
                    parkMap.put(strArr[1], -1);  // 주차 정보 삭제
                }
            }

            for (int i = 0; i < parkMap.size(); i++) {
                for(String s : parkMap.keySet()) {  // 하나씩 순회
                    if(parkMap.get(s) != -1) {
                        int difTime = 23 * 60 + 59 - parkMap.get(s);    // 23:59
                        feeMap.put(s, feeMap.getOrDefault(s, 0) + difTime);
                        parkMap.put(s, -1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(feeMap.entrySet()); // 정렬을 위해 리스트로 저장
            Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));     // 정렬, 차 번호 오름차순

            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                int fee = fees[1];  // 기본 요금
                int time = list.get(i).getValue();  // 주차 시간
                if(time > fees[0])  // 기본 시간 넘으면
                    fee += (int)Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];

                answer[i] = fee;
            }

            return answer;  // 결과 배열 리턴
        }
    }
}