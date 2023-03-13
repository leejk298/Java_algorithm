public class 옹알이2_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            for(int i = 0; i < babbling.length; i++) {
                if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) {
                    continue;
                }

                babbling[i] = babbling[i].replace("aya", "");
                babbling[i] = babbling[i].replace("ye", "");
                babbling[i] = babbling[i].replace("woo", "");
                babbling[i] = babbling[i].replace("ma", "");
                // babbling[i] = babbling[i].replace(" ", "");

                if(babbling[i].length() == 0)
                    answer++;
            }

            return answer;
        }
    }
}
