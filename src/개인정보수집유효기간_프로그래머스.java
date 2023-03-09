import java.util.Arrays;

public class 개인정보수집유효기간_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("2022.05.19",
                new String[] {"A 6", "B 12", "C 3"}, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            // 오늘 날짜
            String[] tArr = today.split("\\.");
            int y = Integer.parseInt(tArr[0]);
            int m = Integer.parseInt(tArr[1]);
            int d = Integer.parseInt(tArr[2]);
            int sum = y * 12 * 28 + m * 28 + d;

            // 개인 정보
            int len = privacies.length;
            int[] answer = new int[len];
            for(int i = 0; i < len; i++) {
                String[] pArr = privacies[i].split(" ");

                int plusM = 0;
                // 유효기간
                for(int j = 0; j < terms.length; j++) {
                    String[] sArr = terms[j].split(" ");

                    if(pArr[1].equals(sArr[0])) {
                        plusM = Integer.parseInt(sArr[1]);

                        break;
                    }
                }

                String[] pArrDate = pArr[0].split("\\.");
                int pY = Integer.parseInt(pArrDate[0]);
                int pM = Integer.parseInt(pArrDate[1]);
                int pD = Integer.parseInt(pArrDate[2]);

                pM += plusM;
                int pSum = pY * 12 * 28 + pM * 28 + pD - 1;

                if(sum > pSum)
                    answer[i] = i + 1;
            }

            int index = 0;
            for(int i = 0; i < len; i++) {
                if(answer[i] > 0)
                    index++;
            }

            int res[] = new int[index];
            int j = 0;
            for(int i = len - 1; i >= 0; i--) {
                if(answer[i] > 0)
                    res[--index] = answer[i];
            }

            return res;
        }
    }
}
