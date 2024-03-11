import java.util.*;
import java.io.*;

/*
mirkovC4nizCC44
C4
 */

public class 문자열폭발_백준 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String inputStr = bf.readLine();    // 입력문자열
        String bombStr = bf.readLine();     // 제거문자열

        Stack<Character> stack = new Stack<>(); // 스택

        for (int i = 0; i < inputStr.length(); i++) {   // 입력문자열 길이만큼
            stack.push(inputStr.charAt(i)); // 하나씩 스택에 삽입

            int count = 0;  // 개수
            if (bombStr.length() <= stack.size()) { // 스택 크기보다 작으면
                for (int j = 0; j < bombStr.length(); j++) {    // 제거문자열 길이만큼
                    if (stack.get(stack.size() - bombStr.length() + j) == bombStr.charAt(j))    // 하나씩 비교
                        count++;    // 개수 카운트

                    if (count == bombStr.length())  // 개수가 같으면
                        for (int k = 0; k < bombStr.length(); k++)  // 개수만큼
                            stack.pop();    // 스택에서 제거
                }
            }
        }

        StringBuilder sb = new StringBuilder(); // 결과문자열

        if (stack.isEmpty())    // 스택이 비어있으면
            System.out.println("FRULA");
        else {  // 비어있지 않으면
            for (char ch : stack)   // 하나씩
                sb.append(ch);  // 결과문자열에 추가
        }

        System.out.println(sb); // 결과문자열 출력
    }
}
