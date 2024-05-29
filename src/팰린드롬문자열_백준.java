import java.util.*;
import java.io.*;

/*
level
 */

public class 팰린드롬문자열_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String str = bf.readLine(); // 입력문자열

        int len = str.length(); // 문자열 길이
        int answer = 1; // 결과값

        for (int i = 0; i < len / 2; i++) { // 절반만큼
            if (str.charAt(i) != str.charAt(len - 1 - i)) { // 비교해서 다르면
                answer = 0; // 0

                break;  // for i 종료
            }
        }

        System.out.println(answer); // 결과값 출력
    }
}
