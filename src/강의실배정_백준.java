import java.util.*;
import java.io.*;

/*
3
1 3
2 4
3 5
 */

public class 강의실배정_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        int[][] arr = new int[N][2];    // 입력배열

        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            arr[i][0] = Integer.parseInt(st.nextToken());   // 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken());   // 끝시간
        }

        Arrays.sort(arr, new Comparator<int[]>() {  // 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) // 시작시간이 같으면
                    return o1[1] - o2[1];   // 끝시간 오름차순 정렬
                return o1[0] - o2[0];   // 시작시간이 다르면 시작시간 오름차순 정렬
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐

        pq.offer(arr[0][1]);    // 처음 수업 끝시간 우선순위 큐에 삽입

        for (int i = 1; i < N; i++) {   // 나머지 수업
            if (pq.peek() <= arr[i][0]) // top 값보다 크거나 같으면
                pq.poll();  // 수업 가능

            pq.offer(arr[i][1]);    // 다음 수업 끝시간 우선순위 큐에 삽입
        }

        System.out.println(pq.size());  // 우선순위 큐 크기 출력
    }
}
