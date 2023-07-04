import java.util.*;

public class 숫자N표현_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 12));
    }

    static class Solution {
        static int num; // 숫자

        public int solution(int N, int number) {

            List<Set<Integer>> arr = new ArrayList<>(); // 집합 리스트

            for(int i = 0; i < 9; i++)  // 8까지만, 0번은 편의상
                arr.add(new HashSet<>());   // 리스트 구현

            arr.get(1).add(N);  // 인덱스 1 저장

            for(int i = 2; i < 9; i++) {    // 2부터
                Set<Integer> set = arr.get(i);

                for(int j = 1; j < i; j++) {   // 1부터
                    Set<Integer> operand = arr.get(j);
                    Set<Integer> operator = arr.get(i - j);

                    for(int n : operand) {
                        for(int t : operator) {
                            set.add(n + t);
                            set.add(n - t);
                            set.add(n * t);
                            if(n != 0 && t != 0)
                                set.add(n / t);
                        }
                    }
                }

                set.add(Integer.parseInt(String.valueOf(N).repeat(i))); // n * 10 + n
            }

            for(Set<Integer> s: arr) { // 각 배열의 집합을 순회
                if(s.contains(number))  // 집합 안에 number가 있으면
                    return arr.indexOf(s);  // 해당 집합 인덱스 리턴
            }

            return -1;  // 없으면 -1 => 8 초과
        }
    }
}
