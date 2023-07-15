import java.io.*;
import java.util.*;

/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
 */

public class 스택_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기
        Stack<Integer> stack = new Stack<>();   // 스택
        StringBuilder sb = new StringBuilder(); // 결과 문자열

        for (int i = 0; i < N; i++) {   // 크기만큼
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
            String str = st.nextToken();    // 연산

            if (str.equals("push")) {   // push
                int num = Integer.parseInt(st.nextToken()); // 숫자
                stack.push(num);
            }

            if (str.equals("pop")) {    // pop
                if (!stack.isEmpty())
                    sb.append(stack.pop() + "\n");
                else
                    sb.append(-1 + "\n");
            }

            if (str.equals("top")) {    // peek
                if (!stack.isEmpty())
                    sb.append(stack.peek() + "\n");
                else
                    sb.append(-1 + "\n");
            }

            if (str.equals("empty")) {  // isEmpty
                if (stack.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }

            if (str.equals("size"))    // size
                sb.append(stack.size() + "\n");
        }

        System.out.print(sb);   // 결과 출력
    }
}
