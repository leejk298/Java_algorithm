import java.util.Arrays;

public class 모의고사_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {1, 3, 2, 4, 2})));
    }

    static class Solution {
        static int[] a = {1, 2, 3, 4, 5};   // 1
        static int[] b = {2, 1, 2, 3, 2, 4, 2, 5};  // 2
        static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    // 3번 수험자

        public int[] solution(int[] answers) {

            int[] answer = {};  // 결과값
            int[] count = new int[3];   // 초기화

            for(int i = 0; i < answers.length; i++) {   // 입력배열 크기만큼
                if(answers[i] == a[i % 5])  // 1
                    count[0]++;
                if(answers[i] == b[i % 8])  // 2
                    count[1]++;
                if(answers[i] == c[i % 10]) // 3
                    count[2]++;
            }

            int max = 0;    // 최대값
            for(int c : count)  // 배열 순회
                if(max < c) // 크면
                    max = c;    // 갱신

            int size = 0;   // 최대값이 여러 명인 경우
            for(int c : count)  // 배열 순회
                if(max == c)    // 같으면
                    size++; // 크기 늘려주기

            answer = new int[size]; // 초기화
            int index = 0;  // 결과배열 인덱스
            for(int i = 0; i < 3; i++)  // 3
                if(count[i] == max) // 같으면
                    answer[index++] = i + 1;    // 해당 수험자 저장

            return answer;  // 결과배열 리턴
        }
    }
}
