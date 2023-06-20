import java.io.*;

/*
55-50+40
 */

public class 잃어버린괄호_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        String[] str = bf.readLine().split("-");    // 한 줄 스트링, - 기준으로 문자열 배열에 저장

        int res = 0;    // 결과값
        for(int i = 0; i < str.length; i++) {   // 배열 크기만큼
            int sum = 0;    // - 기준으로 나눈 문자열들 더하기

            String[] tmp = str[i].split("[+]"); // 정규식 [+]: + 기준으로 나눔
            for(String num : tmp)   // 순회하여
                sum += Integer.parseInt(num);   // 더해줌

            if(i == 0)  // 첫 원소는
                res += sum; // 무조건 숫자이므로 덧셈
            else    // 나머지는
                res -= sum; // 뺄셈
        }

        System.out.println(res);    // 결과값 출력
    }
}
