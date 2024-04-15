import java.io.*;
import java.util.*;

public class 최솟값구하기_Deque_010 {

    static class Node { // Node 클래스
        // 클래스 = 멤버변수 + 멤버함수
        public int index; // 멤버변수
        public int value;

        Node(int index, int value) { // 멤버함수, 생성자 => 클래스명과 동일 // parameter constructor
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링 저장

        int N = Integer.parseInt(st.nextToken()); // 덱 크기, 토큰 단위로 끊어서 정수로 파싱 후 저장
        int M = Integer.parseInt(st.nextToken()); // 윈도우 크기

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링 저장

        Deque<Node> myDeque = new LinkedList<>(); // Node 자료형의 LinkedList 클래스의 Deque 구조인 myDeque 선언

        for (int i = 0; i < N; i++) { // N 만큼
            int now = Integer.parseInt(st.nextToken()); // 현재값 저장

            while (!myDeque.isEmpty() && myDeque.getLast().value > now) // 덱이 비어있지않고 마지막위치 노드갑이 현재값보다 크면
                myDeque.removeLast(); // 마지막위치 노드 삭제

            myDeque.addLast(new Node(i, now)); // 마지막위치에 현재 노드 삽입 -> Node 함수 호출

            if (myDeque.getFirst().index <= i - M) // 첫위치에 노드 인덱스가 윈도우 범위 넘어가면
                myDeque.removeFirst(); // 첫위치 노드 삭제

            bw.write(myDeque.getFirst().value + " "); // 첫 위지 노드값 버퍼에 쓰기
        }

        bw.flush(); // 버퍼에 저장되어있는 값 출력
        bw.close(); // 종료
    }
}
