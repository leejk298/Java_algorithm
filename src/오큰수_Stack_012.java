import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_Stack_012 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼

        int N = Integer.parseInt(bf.readLine()); // 크기, 버퍼 한 줄 스트링을 정수로 파싱
        int A[] = new int[N]; // 입력 배열
        int res[] = new int[N]; // 결과 배열

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        for (int i = 0; i < N; i++) // N 만큼
            A[i] = Integer.parseInt(st.nextToken()); // 토큰으로 나눠 배열에 저장

        Stack<Integer> myStack = new Stack<>(); // 정수형 스택 선언

        myStack.push(0); // 처음엔 그냥 push, index로 관리

        for (int i = 1; i < N; i++) { // 1부터 N만큼
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) { // 비어있지않고 top의 값이 들어오는 값보다 작으면
                res[myStack.pop()] = A[i]; // pop하여 결과 배열의 해당 인덱스 값에 들어오는 값 저장
            }

            myStack.push(i); // 해당 인덱스 push
        }

        while (!myStack.isEmpty()) // 크기만큼 연산이 끝나면
            res[myStack.pop()] = -1; // 결과 배열에 비어있는 해당 인덱스 값에 -1 저장

        for (int i = 0; i < N; i++) // N 만큼
            System.out.print(res[i] + " "); // 결과 배열값 출력
    }
}
