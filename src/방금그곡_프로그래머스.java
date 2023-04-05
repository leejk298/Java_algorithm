public class 방금그곡_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
    }

    static class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";   // 초기화

            m = substitution(m);    // # 치환

            int max = 0;    // 최대값
            for(int i = 0; i < musicinfos.length; i++) {
                String[] str = musicinfos[i].split(","); // 문자열배열

                String title = str[2];  // 제목
                String music = substitution(str[3]);    // 악보
                String[] s = str[0].split(":"); // 시작
                String[] e = str[1].split(":"); // 종료

                // 재생 시간
                int time = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]) - (Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]));

                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < time; j++)   // 재생 시간만큼
                    sb.append(music.charAt(j % music.length()));    // 문자열 생성

                if(sb.toString().contains(m) && max < sb.toString().length()) { // 가장 긴 문자열 반환
                    max = sb.toString().length();
                    answer = title;
                }

            }

            return answer;
        }

        static String substitution(String s) {  // # 치환
            s = s.replaceAll("A#", "a");
            s = s.replaceAll("C#", "c");
            s = s.replaceAll("D#", "d");
            s = s.replaceAll("F#", "f");
            s = s.replaceAll("G#", "g");

            return s;

        }
    }
}
