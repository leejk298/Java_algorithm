import java.io.*;
import java.util.*;

/*
15
push 1
push 2
front
back
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
front
 */

public class 큐_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기
        Queue<Integer> queue = new LinkedList<>();  // 큐, FIFO
        StringBuilder sb = new StringBuilder(); // 결과 문자열
        int rear = 0;   // 자바에서 자료구조 큐의 rear 위치를 나타내는 함수가 없으므로 변수로 관리

        for(int i = 0; i < N; i++) {    // 크기만큼
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
            String str = st.nextToken();    // 연산

            if(str.equals("push")) {    // push
                int num = Integer.parseInt(st.nextToken());
                rear = num; // rear 위치값 저장
                queue.offer(num);
            }

            if(str.equals("pop")) { // pop
                if(queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(queue.poll() + "\n");
            }

            if(str.equals("size"))  // size
                sb.append(queue.size() + "\n");

            if(str.equals("empty")) {   // isEmpty
                if(queue.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }

            if(str.equals("front")) {   // front 위치값, peek
                if(queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(queue.peek() + "\n");
            }

            if(str.equals("back")) {    // rear 위치값
                if(queue.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(rear + "\n");
            }
        }

        System.out.print(sb);   // 결과 출력
    }
}
