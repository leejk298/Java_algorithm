import java.util.*;
import java.io.*;

/*
This is String
SPACE    1    SPACE
 S a M p L e I n P u T
0L1A2S3T4L5I6N7E8
 */

public class 문자열분석_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringBuilder sb = new StringBuilder(); // 결과문자열

        String str; // 입력문자열
        while((str = bf.readLine()) != null) {  // null 아니면
            int small = 0, capital = 0, number = 0, space = 0;  // 개수

            for(int i = 0; i < str.length(); i++) { // 문자열 길이만큼
                char ch = str.charAt(i);    // 해당 문자

                if(ch == ' ')   // 공백
                    space++;
                if(Character.isUpperCase(ch))   // 대문자
                    capital++;
                if(Character.isLowerCase(ch))   // 소문자
                    small++;
                if(Character.isDigit(ch))   // 숫자
                    number++;
            }

            sb.append(small + " " + capital + " " + number + " " + space + "\n");   // 개수 저장
        }

        System.out.print(sb);   // 결과 출력
    }
}
