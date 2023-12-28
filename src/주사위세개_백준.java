import java.util.*;
import java.io.*;

/*
3 3 6
 */

public class 주사위세개_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = 0, max = 0;   // 총 합, 최대값

        if (a == b && b == c)   // 세 개가 다 같으면
            sum = 10000 + a * 1000;
        else if (a == b && a != c)  // 두 개가 같으면
            sum = 1000 + a * 100;
        else if (b == c && b != a)
            sum = 1000 + b * 100;
        else if (c == a && c != b)
            sum = 1000 + c * 100;
        else {  // 전부 다 다르면
            max = a;    // 최대값 초기화
            if(max < b)
                max = b;
            if (max < c)
                max = c;
            sum = max * 100;
        }

        System.out.println(sum);    // 총 합 출력
    }
}
