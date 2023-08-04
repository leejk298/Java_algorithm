import java.util.*;
import java.io.*;

/*
Mississipi
 */

public class 단어공부_백준 {
    static String str;  // 문자열
    static Map<Character, Integer> hashMap; // 해시맵
    static char resChar;    // 결과 문자

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        str = bf.readLine().toUpperCase();  // 대문자로 변환

        // 초기화
        char[] ch = str.toCharArray();  // 문자 배열
        hashMap = new HashMap<>();  // 해시맵

        for(char c : ch)    // 문자 배열 순회
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1); // 해시맵 저장
    }

    public static void printMaxCount() {    // 최대 개수의 문자 출력

        int max = 0;    // 최대값
        for(char c : hashMap.keySet()) {    // 해시맵 순회
            int count = hashMap.get(c); // 밸류값

            max = Math.max(max, count); // 최대값 저장
        }

        int res = 0;    // 결과값
        for(char c : hashMap.keySet()) {    // 해시맵 순회
            int count = hashMap.get(c); // 밸류값

            if(max == count) {  // 최대값이랑 같으면
                res++;  // 개수 카운트
                resChar = c;    // 해당 문자 저장
            }
        }

        if(res == 1)    // 1 이면
            System.out.println(resChar);    // 결과 문자 출력
        else    // 아니면
            System.out.println("?");    // ? 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printMaxCount();    // 최대 개수의 문자 출력
    }
}
