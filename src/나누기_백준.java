import java.io.*;

/*
1000
3
 */

public class 나누기_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 나누어 지는 수
        int F = Integer.parseInt(bf.readLine());    // 나누는 수

        N /= 100;   // N의 끝 두 자리를 00으로 만들기
        N *= 100;

        int answer = 0; // 결과값

        while (N % F != 0) {    // 나누어 떨어질 때까지 반복
            N++;
            answer++;
        }

        if (answer < 10)    // 10 보다 작으면
            System.out.println("0" + answer);   // 앞에 0을 붙여서
        else    // 크거나 같으면
            System.out.println(answer); // 결과값 출력
    }
}
