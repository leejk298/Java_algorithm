import java.util.*;
import java.io.*;

/*
Mississipi
 */

public class 단어공부_백준 {
    static Map<Character, Integer> hashMap; // 해시맵

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String str = bf.readLine().toUpperCase();   // 입력 문자열

        hashMap = new HashMap<>();  // 해시맵

        for(char ch : str.toCharArray())    // 입력 문자열 순회
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);   // 해시맵 저장
    }

    public static void printMaxCount() {    // 최대값 출력

        int max = 0, res = 0;   // 최대값, 결과값

        for(char ch : hashMap.keySet()) {   // 해시맵의 키값 순회
            int count = hashMap.get(ch);    // 키값에 해당하는 밸류값

            max = Math.max(max, count); // 최대값 저장
        }

        char resChar = '\0';    // 결과 문자
        for(char ch : hashMap.keySet()) {   // 해시맵의 키값 순회
            int count = hashMap.get(ch);    // 키값에 해당하는 밸류값

            if(max == count) {  // 최대값과 같으면
                res++;  // 결과값 카운트
                resChar = ch;   // 결과 문자 저장
            }
        }

        if(res == 1)    // 결과값이 1이면
            System.out.println(resChar);    // 결과 문자 출력
        else    // 여러개이면
            System.out.println("?");    // ? 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printMaxCount();    // 최대 개수의 문자 출력
    }
}
