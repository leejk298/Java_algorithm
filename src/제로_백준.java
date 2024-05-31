import java.util.*;
import java.io.*;

/*
4
3
0
4
0
 */

public class 제로_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기
        Stack<Integer> stack = new Stack<>();   // 스택

        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int num = Integer.parseInt(st.nextToken()); // 숫자

            if (num == 0)   // 0이면
                stack.pop();    // pop
            else    // 0이 아니면
                stack.push(num);    // push
        }

        int sum = 0;    // 결과값

        for (int num : stack)   // 스택 순회
            sum += num; // 총합 갱신

        System.out.println(sum);    // 결과값 출력
    }
}
