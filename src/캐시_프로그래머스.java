import java.util.*;

public class 캐시_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> list = new LinkedList<>();

            if(cacheSize == 0)
                return cities.length * 5;

            for(int i = 0; i < cities.length; i++) {
                String str = cities[i].toUpperCase();

                if(list.remove(str)) {
                    answer += 1;
                    list.add(str);
                } else {
                    answer += 5;

                    if(list.size() >= cacheSize)
                        list.remove(0);

                    list.add(str);
                }
            }

            return answer;
        }
    }
}
