import java.util.*;

public class 파일명정렬_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
    }

    static class Solution {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];     // 결과배열
            List<File> list = new ArrayList<>();    // 문자열 리스트

            int index = 0;  // 순서
            for(String file : files) {  // 문자열 하나씩
                boolean flag = false;   // 숫자 플래그
                StringBuilder head = new StringBuilder();
                StringBuilder num = new StringBuilder();
                StringBuilder tail = new StringBuilder();

                for (int i = 0; i < file.length(); i++) {   // 문자열 길이만큼
                    char c = file.charAt(i);    // 문자 하나씩
                    if (c >= '0' && c <= '9') { // 숫자면
                        num.append(c);  // 문자열추가
                        flag = true;    // true -> tail, false -> head
                    } else {    // 문자면
                        if (!flag)  // 플래그 기준으로
                            head.append(c); // head
                        else {
                            tail.append(file.substring(i)); // tail, 전부 추가

                            break;  // for-문자열 탈출
                        }
                    }
                }

                list.add(new File(index++, head.toString(), num.toString(), tail.toString()));  // 리스트에 추가
            }

            Collections.sort(list); // 리스트 정렬 -> CompareTo()메소드

            for(int i = 0; i < answer.length; i++) {
                File f = list.get(i);
                answer[i] = f.head + f.num + f.tail;
            }

            return answer;
        }

        static class File implements Comparable<File> { // Comparable 인터페이스 구현 -> CompareTo() 오버라이딩
            int i;
            String head, num, tail;

            public File(int i, String head, String num, String tail) {
                this.i = i;
                this.head = head;
                this.num = num;
                this.tail = tail;
            }

            @Override
            public int compareTo(File f) {
                if(this.head.equalsIgnoreCase(f.head)) {    // 대, 소문자 상관없이 비교해서 같으면
                    if(Integer.parseInt(this.num) == Integer.parseInt(f.num)) { // num 문자열 -> 숫자
                        return this.i - f.i;
                    }

                    return Integer.parseInt(this.num) - Integer.parseInt(f.num);
                }

                return this.head.toLowerCase().compareTo(f.head.toLowerCase()); // 다르면 오름차순
            }
        }
    }
}
