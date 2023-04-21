import java.io.*;
import java.util.*;

public class 큰수식찾기_구름Level {
    public static void main(String[] args) throws Exception {
        List<Long> list = new ArrayList<>();    // 결과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        String input = br.readLine();   // 한 줄 스트링

        String[] str = input.split(" ");    // 공백기준 나누어

        for(int i = 0; i < 2; i++) {    // 수식 2개
            List<Long> nums = new ArrayList<>();    // 숫자
            List<Character> op = new ArrayList<>(); // 연산
            String num = "";    // 문자열

            for(int j = 0; j < str[i].length(); j++) {  // 한 줄 길이만큼
                char c = str[i].charAt(j);  // 문자하나씩

                if(c >= '0' && c <= '9') {  // 숫자면
                    num += c;   // 하나 추가해서
                } else {    // 연산이면
                    nums.add(Long.parseLong(num));  // 숫자 리스트에 추가
                    op.add(c);  // 연산 리스트에 추가
                    num = "";   // 숫자 문자열 초기화
                }
            }

            nums.add(Long.parseLong(num));  // 숫자 리스트에 추가
            long sum = 0;   // 합
            for(int k = 0; k < op.size(); k++) {    // 연산 개수만큼
                if(op.get(k) == '*') {  // 곱 우선
                    sum = calcNum(nums.remove(k), nums.remove(k), op.remove(k));
                    nums.add(k--, sum);
                }
            }

            for(int k = 0; k < op.size(); k++) {    // -, +
                sum = calcNum(nums.remove(k), nums.remove(k), op.remove(k));
                nums.add(k--, sum);
            }

            list.add(nums.get(0));  // 계산된 값, 결과 리스트에 추가
        }

        long a = list.get(0);
        long b = list.get(1);

        if(a > b)
            System.out.print(a);
        else
            System.out.print(b);
    }

    public static long calcNum(long a, long b, char c) {    // 계산
        switch(c) {
            case '*' :
                return a * b;
            case '+' :
                return a + b;
            default :
                return a - b;
        }
    }
}