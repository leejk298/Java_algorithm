import java.util.*;
import java.io.*;

public class 최고비용_벨만포드_060 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드
        int start = Integer.parseInt(st.nextToken()); // 출발
        int end = Integer.parseInt(st.nextToken()); // 도착
        int M = Integer.parseInt(st.nextToken()); // 엣지

        cEdge edges[] = new cEdge[M]; // 엣지리스트
        long D[] = new long[N]; // 최고비용
        long money[] = new long[N]; // 방문비용

        for (int i = 0; i < N; i++) // 노드 개수만큼
            D[i] = Integer.MIN_VALUE; // 최고비용배열 => 벨만포드(최단경로) 반대로 => 전부 제일작은값으로 설정

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            edges[i] = new cEdge(S, E, W); // 엣지리스트 추가
        }

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        for (int i = 0; i < N; i++) // 노드 개수만큼
            money[i] = Long.parseLong(st.nextToken()); // 방문비용 설정

        D[start] = money[start]; // 시작노드의 비용 갱신
        for (int i = 0; i < N + 100; i++) { // 양수사이클을 판단하기 위해 충분히 큰 수로 반복
            for (int j = 0; j < M; j++) { // 엣지 개수만큼
                int nowS = edges[j].S; // 값 설정
                int nowE = edges[j].E;
                int nowW = edges[j].W;

                if (D[nowS] == Long.MIN_VALUE) // 시작노드가 갱신이 없으면 (방문하지않은) skip
                    continue;

                else if (D[nowS] == Long.MAX_VALUE) // 시작노드가 양수사이클에 속해있으면
                    D[nowE] = Long.MAX_VALUE; // 끝노드도 속하도록 => 둘이 연결되어있으므로

                else if (D[nowE] < D[nowS] + money[nowE] - nowW) { // 갱신이 필요하면
                    D[nowE] = D[nowS] + money[nowE] - nowW; // 갱신

                    if (i >= N - 1) // N-1번 반복 이후 업데이트가 되면
                        D[nowE] = Long.MAX_VALUE; // 양수사이클이므로 끝노드 갱신
                }
            }
        }

        if (D[end] == Long.MIN_VALUE) // 도착노드가 갱신이 없으면
            System.out.println("gg"); // 도착 불가능

        else if (D[end] == Long.MAX_VALUE) // 도착노드가 갱신이 있고 무한히 큰 값이면
            System.out.println("Gee"); // 양수사이클 존재

        else // 이외의 경우
            System.out.println(D[end]); // 도착노드의 최고로 벌 수 있는 비용 출력
    }
}

class cEdge { // Edge 클래스
    int S, E, W; // 멤버변수

    public cEdge(int S, int E, int W) { // 멤버함수, 파라미터 생성자
        this.S = S;
        this.E = E;
        this.W = W;
    }
}
