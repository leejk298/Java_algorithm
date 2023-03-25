import java.util.*;

public class 전화번호목록_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"119", "97674223", "1195524421"}));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phone_book.length; i++)
                map.put(phone_book[i], i);

            for(int i = 0; i < phone_book.length; i++) {
                for(int j = 0; j < phone_book[i].length(); j++) {
                    if(map.containsKey(phone_book[i].substring(0, j)))
                        return false;
                }
            }

            return true;
        }
    }
}
