import java.util.*;
import java.io.*;

/*
ABABA
 */

public class 팰린드롬만들기_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String str = bf.readLine(); // 입력문자열
        int length = str.length();  // 문자열 길이

        int[] arr = new int[26];    // 알파벳 배열
        for(int i = 0; i < length; i++) // 길이만큼
            arr[str.charAt(i) - 'A']++; // 해당하는 알파벳 인덱스에 저장

        int midAlphabet = 0, count = 0; // 가운데 들어갈 알파벳과 홀수 개수
        for(int i = 0; i < arr.length; i++) {   // 길이만큼
            if(arr[i] % 2 != 0) {   // 짝수가 아니면
                midAlphabet = i;    // 알파벳 번호 저장
                count++;    // 홀수 개수 카운트
            }
        }

        if(count > 1 || (count == 1 && length % 2 == 0)) {  // 홀수가 1개보다 많거나 1개일 때 길이가 짝수이면
            System.out.println("I'm Sorry Hansoo"); // 팰린드롬 만들기 불가

            return; // 함수 종료
        }

        StringBuilder sb = new StringBuilder(); // 앞부분 문자열

        for(int i = 0; i < arr.length; i++) // 길이만큼
            for(int j = 0; j < arr[i] / 2; j++) // 해당 알파벳의 절반만
                sb.append((char)(i + 'A')); // 저장

        StringBuilder res = new StringBuilder(sb.toString());   // 뒷부분 문자열

        if(count == 1)  // 홀수가 있으면
            sb.append((char)(midAlphabet + 'A'));   // 가운데 저장

        System.out.println(sb.toString() + res.reverse());  // 뒷부분 문자열 뒤집어서 합치기
    }
}
