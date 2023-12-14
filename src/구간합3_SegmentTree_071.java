import java.util.*;
import java.io.*;

public class 구간합3_SegmentTree_071 {
    static long tree[]; // 트리

    public static long getSum(int S, int E) { // 구간합

        long partSum = 0; // 부분합

        while (S <= E) { // 역전이 아니면 반복
            if (S % 2 == 1) { // 시작노드가 오른쪽자식노드이면 부모노드가 영향력 X => 독립노드로 설정
                partSum += tree[S]; // 부분합 갱신
                S++; // 왼쪽자식노드이면 오른쪽으로, 오른쪽이면 독립노드 -> 건너띄어가기
            }

            if (E % 2 == 0) { // 끝노드가 왼쪽자식노드이면 부모노드가 영향력 X => 독립노드로 설정
                partSum += tree[E]; // 부분합 갱신
                E--; // 오른쪽자식노드이면 왼쪽으로, 왼쪽이면 독립노드 -> 건너띄어가기
            }

            S /= 2; // 부모노드로 이동
            E /= 2;
        }

        return partSum; // 값 리턴
    }

    public static void updateValue(int index, long val) { // 업데이트

        long diff = val - tree[index]; // 변경할 값과 원래 값의 차이

        while (index > 0) { // 인덱스가 유효하면
            tree[index] += diff; // 해당 노드부터 상위 부모노드 쭉 갱신
            index /= 2; // 부모노드로 이동
        }
    }

    public static void setTree(int i) { // 세그먼트트리 만들기

        while (i != 1) { // 루트노드가 아니면
            tree[i / 2] += tree[i]; // 리프노드(원본데이터)로부터 상위노드 합배열 만들기
            i--; // 인덱스 이동
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 업데이트 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간합 출력 횟수
        int treeHeight = 0, t = N; // 트리높이(k), 노드 개수

        while (t != 0) { // 2^k >= N, 트리높이(k) 구하기 => 2^k >= 5 => k = 3
            t /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^k * 2, 배열크기 => 2^3 * 2 = 16
        int leafNodeStartIndex = treeSize / 2; // 리프노드시작인덱스: 16/2 = 8

        tree = new long[treeSize]; // 트리 초기화

        for (int i = leafNodeStartIndex; i < leafNodeStartIndex + N; i++) // 원본데이터 저장 => 리프노드
            tree[i] = Long.parseLong(bf.readLine()); // 리프노드 입력받기

        setTree(treeSize - 1); // 세그먼트트리 만들기

        for (int i = 0; i < M + K; i++) { // 업데이트, 구간합 출력
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int a = Integer.parseInt(st.nextToken()); // a
            int S = Integer.parseInt(st.nextToken()); // 시작, 인덱스
            long E = Long.parseLong(st.nextToken()); // 끝, 값

            if (a == 1) // a가 1이면 업데이트, 질의 인덱스를 트리에 맞게 리프노드 인덱스로 갱신
                updateValue(S + leafNodeStartIndex - 1, E); // 리프노드 인덱스: index + 2^k - 1

            else if (a == 2) { // a가 2이면 구간합 출력, 질의 인덱스를 트리에 맞게 리프노드 인덱스로 갱신
                S = S + leafNodeStartIndex - 1; // 리프노드 인덱스
                E = E + leafNodeStartIndex - 1;

                System.out.println(getSum(S, (int) E)); // 구간합 출력
            }
        }

        bf.close(); // 입력 버퍼 닫기
    }
}
