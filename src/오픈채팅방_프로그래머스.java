import java.util.*;

public class 오픈채팅방_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
        )));
    }

    static class Solution {
        public String[] solution(String[] record) {
            Map<String, String> hashMap = new HashMap<>();

            int changeCount = 0;
            for(int i = 0; i < record.length; i++) {
                String[] str = record[i].split(" ");

                if(str[0].equals("Enter")) {
                    hashMap.put(str[1], str[2]);
                }

                if(str[0].equals("Change")) {
                    hashMap.put(str[1], str[2]);
                    changeCount++;
                }
            }

            List<String> list = new ArrayList<>();

            for(int i = 0; i < record.length; i++) {
                String[] str = record[i].split(" ");
                String name = hashMap.get(str[1]);

                if(str[0].equals("Enter"))
                    list.add(name + "님이 들어왔습니다.");

                if(str[0].equals("Leave"))
                    list.add(name + "님이 나갔습니다.");
            }

            return list.stream().toArray(String[] :: new);
        }
    }
}
