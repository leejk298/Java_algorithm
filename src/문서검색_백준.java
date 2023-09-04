import java.util.*;
import java.io.*;

/*
ababababa
aba
 */

public class 문서검색_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String str = bf.readLine(); // 입력 문자열
        String target = bf.readLine();  // 찾을 문자열

        int lenS = str.length(), lenT = target.length();    // 문자열 길이

        int count = 0;  // 개수
        for(int i = 0; i <= lenS - lenT; i++) { // 찾을 범위
            if(str.substring(i, i + lenT).equals(target)) { // 찾을 문자열 길이만큼 비교하여 같으면
                count++;    // 개수 카운트

                i += lenT - 1;  // 다음 인덱스
            }
        }

        System.out.println(count);  // 개수 출력
    }
}
