import java.util.*;

public class 실패율_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int user = stages.length;
            List<double[]> list = new ArrayList<>();

            for(int i = 1; i <= N; i++) {
                int count = 0;

                for(int j = 0; j < stages.length; j++) {
                    if(i == stages[j])
                        count++;
                }

                if(count == 0) {
                    list.add(new double[] {i, 0});

                    continue;
                }

                list.add(new double[] {i, (double)count / user});
                user -= count;
            }

            list.sort((o1, o2) -> Double.compare(o2[1], o1[1]));

            for(int i = 0; i < list.size(); i++)
                answer[i] = (int)list.get(i)[0];

            return answer;
        }
    }
}
