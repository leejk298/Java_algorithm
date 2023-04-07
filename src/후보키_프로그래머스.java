import java.util.*;

public class 후보키_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]
                {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    static class Solution {
        static int answer;  // 결과
        static int n, m;    // 행 열
        static List<HashSet<Integer>> candidateKey; // 후보키 리스트
        static String[][] r;    // 전역

        public int solution(String[][] relation) {
            r = relation; // 복사
            // 초기화
            answer = 0;
            candidateKey = new ArrayList<>();
            n = r.length;
            m = r[0].length;

            for(int i = 1; i <= m; i++)
                DFS(0, i, 0, new HashSet<>());  // 후보키 조합 생성

            return answer;
        }

        static void DFS(int index, int size, int depth, HashSet<Integer> set) {
            if(depth == size) { // 조합 완성되면
                if(!isUnique(set)) {    // 유일성
                    return;
                }

                for(HashSet<Integer> key : candidateKey) {  // 최소성
                    if(set.containsAll(key))    // 새로 만들어진 조합의 키가 이미 있는 키가 전부 들어가있는 경우
                        return; // 최소성 X
                }

                // 둘 다 만족하면
                candidateKey.add(set);  // 저장
                answer++;   // 카운트 세기

                return;
            }

            for(int i = index; i < m; i++) {    // 열 개수만큼, 조합
                HashSet<Integer> newSet = new HashSet<>(set);
                newSet.add(i);
                index++;

                DFS(index, size, depth + 1, newSet);
            }
        }

        static boolean isUnique(HashSet<Integer> set) { // 유일성 검사
            List<String> list = new ArrayList<>();  // 인덱스에 해당하는 문자열 리스트

            for(int i = 0; i < n; i++) {    // 행 개수만큼
                StringBuilder sb = new StringBuilder(); // 문자열 만들기

                for(int j : set) {  // 해당 인덱스 만큼
                    sb.append(r[i][j]); // 문자열 추가
                }

                if(!list.contains(sb.toString())) { // 리스트에 없다면
                    list.add(sb.toString());    //  추가
                } else  // 있으면
                    return false;   // 유일성 X
            }

            return true;    // 전부 다 추가되었으므로 유일성 O
        }
    }
}
