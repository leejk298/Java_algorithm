import java.util.*;

public class 뉴스클러스터링_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aa1+aa2", "AAAA12"));
    }

    static class Solution {
        public int solution(String str1, String str2) {
            int union = 0, intersection = 0;    // 합, 교집합

            Map<String, Integer> hashMap1 = new HashMap<>();    // 문자열 매핑
            Map<String, Integer> hashMap2 = new HashMap<>();

            str1 = str1.toLowerCase();  // 소문자
            str2 = str2.toLowerCase();

            for(int i = 0; i < str1.length() - 1; i++) {    // 문자열1
                String str = str1.substring(i, i + 2).replaceAll("[^a-z]", ""); // 2글자씩 나눠서 소문자인 경우만

                if(str.length() != 2)   // 2글자가 아니면 건너뛰기
                    continue;

                hashMap1.put(str, hashMap1.getOrDefault(str, 0) + 1);   // 저장
            }


            for(int i = 0; i < str2.length() - 1; i++) {
                String str = str2.substring(i, i + 2).replaceAll("[^a-z]", "");

                if(str.length() != 2)
                    continue;

                hashMap2.put(str, hashMap2.getOrDefault(str, 0) + 1);
            }

            if(hashMap1.size() == 0 && hashMap2.size() == 0)    // 공집합이므로 그대로 리턴
                return 65536;

            for(String s : hashMap1.keySet()) { // 문자열 1에 대해
                if(hashMap2.containsKey(s)) {   // 문자열 2에 해당 문자가 있으면
                    intersection += Math.min(hashMap1.get(s), hashMap2.get(s)); // 교집합은 최소
                    union += Math.max(hashMap1.get(s), hashMap2.get(s));        // 합집합은 최대
                    hashMap2.remove(s); // 문자열 2에 해당 문자 제거
                } else {    // 없으면
                    union += hashMap1.get(s);   // 교집합은 없으므로 합집합만 추가해줌
                }
            }

            for(String s : hashMap2.keySet()) { // 문자열 2 나머지에 대해
                union += hashMap2.get(s);   // 합집합에 추가
            }

            return intersection * 65536 / union;    // 결과 리턴
        }
    }
}
