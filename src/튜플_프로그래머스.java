import java.util.*;

public class 튜플_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }

    static class Solution {
        public List<Integer> solution(String s) {
            String [] arrStr = s.replaceAll("[{}]", " ").trim().split(" ,");  // {} -> 공백 -> 공백제거(문자열 양 끝) -> _,으로 구분

            List<Integer> list = new ArrayList<>(); // 결과 리스트
            Set<Integer> hs = new HashSet<>(); // 중복제거, 집합

            Arrays.sort(arrStr, (o1, o2) -> (o1.length() - o2.length()));  // 문자열 길이 오름차순 정렬

            for(String str : arrStr){ // 문자열 배열 하나씩 순회
                for(String st : str.split(",")){    // ,구분 -> 문자열 하나씩 
                    int num  = Integer.parseInt(st.trim()); // 공백제거 후 정수로 파싱

                    if(hs.contains(num))    // 중복이면 건너뛰기
                        continue;
                    // 중복이 아니면
                    hs.add(num);   // 집합에 추가  
                    list.add(num);  // 리스트에 추가
                }
            }
            
            return list;    // 결과리스트 리턴
        }
    }
}

