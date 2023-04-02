public class 스킬트리_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(int i = 0; i < skill_trees.length; i++) {
                String str = skill_trees[i].replaceAll("[^" + skill + "]", "");

                String tmp = skill.substring(0, str.length());

                if(str.equals(tmp))
                    answer++;
            }

            return answer;
        }
    }
}
