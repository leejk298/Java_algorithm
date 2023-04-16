import java.util.*;

public class 뒤통수가따가워_구름Level {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기

        Stack<Long> stack = new Stack<>();  // 스택
        long[] size = new long[N];      // 결과 배열

        for(int i = 0; i < N; i++) {    // 크기만큼
            long num = sc.nextInt();    // 입력받아

            size[i] = stack.size(); // 스택 크기 저장
            while(!stack.isEmpty() && stack.peek() <= num)  // 비어있지 않고 top 값이 num 보다 작거나 같으면
                stack.pop();    // pop

            stack.push(num);    // push
        }

        for(long s : size)
            System.out.print(s + " ");  // 결과 출력
    }
}