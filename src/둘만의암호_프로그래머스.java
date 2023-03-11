public class 둘만의암호_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aukks", "wbqd", 5));
    }

    static class Solution {
        public String solution(String s, String skip, int index) {
            char[] ch = s.toCharArray();

            for(int i = 0; i < ch.length; i++) {
                for(int j = 0; j < index; j++) {
                    do {
                        ch[i]++;
                        if(ch[i] > 'z')
                            ch[i] = 'a';
                    } while(skip.contains(String.valueOf(ch[i])));
                }
            }

            String answer = String.valueOf(ch);

            return answer;
        }
    }
}
