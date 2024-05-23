import java.util.*;

/*
a
tv
ptoui
bontres
zoggax
wiinq
eep
houctuh
end
 */

public class 비밀번호발음하기_백준 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        String str = "";    // 입력문자열 초기화

        while (true) {
            str = sc.next();

            if (str.equals("end"))  // end 종료
                break;

            boolean mFlag = false, jmFlag = true, eoFlag = true; // 모음, 연속된 자음모음, eo 문자
            int mCount = 0, jCount = 0; // 연속된 모음, 자음 개수

            for (int i = 0; i < str.length(); i++) {    // 길이만큼
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                        str.charAt(i) == 'o' || str.charAt(i) == 'u') { // 모음이면
                    mFlag = true;   // 모음
                    mCount++;   // 개수 카운트
                    jCount = 0; // 자음 개수 초기화

                    if (mCount >= 3) {  // 3개 이상이면
                        jmFlag = false; // 비밀번호 불가능

                        break;  // for i 종료
                    }
                } else {    // 자음이면
                    jCount++;   // 개수 카운트
                    mCount = 0; // 모음 개수 초기화

                    if (jCount >= 3) {  // 3개 이상이면
                        jmFlag = false; // 비밀번호 불가능

                        break;  // 다음 문자열로
                    }
                }

                if (i >= 1) {   // eo 확인
                    if (str.charAt(i) != 'e' && str.charAt(i) != 'o')   // e, o가 아니면
                        if (str.charAt(i) == str.charAt(i - 1)) // 같으면
                            eoFlag = false; // 비밀번호 불가능
                }
            }

            if (jmFlag && eoFlag && mFlag)  // 전부 다 true
                System.out.println("<" + str + "> is acceptable."); // 비밀번호 가능
            else    // 하나라도 false
                System.out.println("<" + str + "> is not acceptable."); // 비밀번호 불가능
        }
    }
}
