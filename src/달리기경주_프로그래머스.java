import java.util.*;

public class 달리기경주_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})));
    }

    static class Solution {
        public String[] solution(String[] players, String[] callings) {

            Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

            for (int i = 0; i < players.length; i++)    // 길이만큼
                hashMap.put(players[i], i); // 해시맵 저장

            for (String calling : callings) {   // 입력배열 순회
                int nowRank = hashMap.get(calling); // 현재 순위
                String swapPlayer = players[nowRank - 1];   // 바로 앞 플레이어

                hashMap.replace(swapPlayer, nowRank);   // 스왑
                players[nowRank] = swapPlayer;

                hashMap.replace(calling, nowRank - 1);
                players[nowRank - 1] = calling;
            }

            return players; // 결과배열 리턴
        }
    }
}
