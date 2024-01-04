import java.util.*;
import java.io.*;

/*
mirkovC4nizCC44
C4
 */

public class 문자열폭발_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String inputString = bf.readLine(); // 입력문자열
        String bombString = bf.readLine();  // 폭발문자열

        int inputLength = inputString.length(); // 길이
        int bombLength = bombString.length();

        Stack<Character> stack = new Stack<>(); // 스택

        for (int i = 0; i < inputLength; i++) { // 길이만큼
            stack.push(inputString.charAt(i));  // 문자 하나씩 스택에 삽입

            int count = 0;  // 개수
            if (bombLength <= stack.size()) {   // 스택 크기 비교
                for (int j = 0; j < bombLength; j++) {  // 폭발문자열 길이만큼 비교
                    if (stack.get(stack.size() - bombLength + j) == bombString.charAt(j))   // 같으면
                        count++;    // 개수 카운트

                    if (count == bombLength)    // 개수가 길이와 같으면
                        for (int k = 0; k < bombLength; k++)    // 개수만큼
                            stack.pop();    // 스택에서 삭제
                }
            }
        }

        StringBuilder sb = new StringBuilder(); // 결과문자열

        if (stack.isEmpty())    // 다 폭발하면
            System.out.println("FRULA");
        else {  // 아니면
            for (char ch : stack)   // 하나씩 순회
                sb.append(ch);  // 결과문자열에 추가
        }

        System.out.println(sb); // 결과문자열 출력
    }
}
