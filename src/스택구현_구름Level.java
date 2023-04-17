import java.io.*;
import java.util.*;

public class 스택구현_구름Level {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 입력 개수
        M = Integer.parseInt(st.nextToken());   // 스택 사이즈

        Stack<Integer> stack = new Stack<>();   // 스택

        for(int i = 0; i < N; i++) {    // 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            String str = st.nextToken();    // push or pop

            if(str.equals("push")) {    // push 이면
                int num = Integer.parseInt(st.nextToken()); // 숫자

                if(stack.size() <= M - 1)   // 크기보다 작거나 같으면
                    stack.push(num);    // push
                else    // 크면
                    System.out.println("Overflow"); // 오류메시지 출력
            } else {    // pop 이면
                if(stack.isEmpty()) // 비어있으면
                    System.out.println("Underflow");    // 오류메시지 출력
                else    // 비어있지 않으면
                    System.out.println(stack.pop());    // top값 꺼내어 출력
            }
        }
    }
}