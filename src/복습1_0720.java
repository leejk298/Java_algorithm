import java.util.*;

public class 복습1_0720 {

    public static boolean isValidEmail(String s) {  // 이메일이 유효한지

        int count = 0;  // @ 개수
        for(int i = 0; i < s.length(); i++) // 문자열 길이만큼
            if(s.charAt(i) == '@')  // @ 개수 카운트
                count++;

        // 이름에는 영어소문자와 .만 가능 + 1글자 이상
        if(count != 1 || s.charAt(0) == '@')    // 1개가 아니거나 처음에 @이가 나오면 x
            return false;

        String[] tmp = s.split("@");    // @ 기준으로 나눔

        count = 0;  // . 개수
        for(int i = 0; i < tmp[1].length(); i++)    // 도메인이름 + 탑도메인 길이만큼
            if(tmp[1].charAt(i) == '.') // . 개수 카운트
                count++;

        // 도메인이름은 영어소문자만 가능 + 1글자 이상
        if(count != 1)  // 1개가 아니면 x
            return false;

        if(tmp[1].charAt(0) == '.' || tmp[1].charAt(tmp[1].length() - 1) == '.')
            return false;

        String[] str = tmp[1].split("[.]"); // . 기준으로 나눔
        String[] top = {"com", "net", "org"};   // 탑도메인 3개만 가능

        for(String t : top) // 순회
            if(t.equals(str[1]))    // 같으면
                return true;    // true

        return false;   // 다르면 false
    }

    public static int solution(String[] emails) {

        int answer = 0; // 총 개수

        for(String email : emails)  // 순회
            if(isValidEmail(email)) // 유효하면
                answer++;   // 개수 카운트

        return answer;  // 총 개수 리턴
    }

    public static void main(String[] args) {

        String[] emails = {"abc@cc.net", "a@a@.net", "aa@aa.aa", "abac.cd", "a@a.org"};

        System.out.println(solution(emails));
    }
}
