import java.util.Scanner;
import java.util.Stack;

public class 오름차순수열_Stack_011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);	// 입력

        int N = sc.nextInt();	// 크기 입력받기
        int A[] = new int[N];	// 배열

        for (int i = 0; i < N; i++)	// N 만큼
            A[i] = sc.nextInt();	// 배열 입력받기

        Stack<Integer> myStack = new Stack<>();	// 정수형 Stack myStack 선언

        StringBuffer bf = new StringBuffer();	// StringBuffer: 새로운 객체생성 필요없이 스트링 추가 가능 => append()

        int num = 1;	// 자연수
        boolean res = true;	// 결과값 true로 초기화

        for (int i = 0; i < A.length; i++) {	// 배열 길이만큼
            int M = A[i];	// 현재 수열값

            if(M >= num)	// 현재 수열값이 자연수보다 크면
            {
                while(M >= num) {	// 작아질 때까지
                    myStack.push(num++);	// 스택에 삽입, 자연수 1증가
                    bf.append("+\n");	//	+ 추가
                }

                myStack.pop();	//	현재 수열값이 자연수보다 작으면 삭제
                bf.append("-\n");	// - 추가
            }

            else	// 현재 수열값이 작아지면
            {
                int X = myStack.pop();	// top에 있는 값 꺼내서

                if(X > M)	// 현재 수열값과 비교하여 더 크면
                {
                    System.out.println("NO");	// 오름차순 수열 만들기 x
                    res = false;	// 결과값 false로 설정

                    break;	// 반복문 종료
                }

                else
                    bf.append("-\n");
            }
        }

        if(res)	// true면
            System.out.println(bf.toString());	// 버퍼에 있는 값을 스트링으로 변환하여 출력
    }
}
