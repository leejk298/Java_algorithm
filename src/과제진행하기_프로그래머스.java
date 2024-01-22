import java.util.*;

public class 과제진행하기_프로그래머스 {
    static class Solution {
        static class Task { // 과제 클래스
            String name;    // 과목
            int start;      // 시작 시간
            int playTime;   // 걸리는 시간

            public Task(String name, int start, int playTime) { // 파라미터 생성자, 우선순위 큐에 삽입될 객체
                this.name = name;
                this.start = start;
                this.playTime = playTime;
            }

            public Task(String name, int playTime) {    // 파라미터 생성자, 스택에 삽입될 객체 => 시작 시간은 필요x
                this.name = name;
                this.playTime = playTime;
            }
        }

        public String[] solution(String[][] plans) {

            List<String> answer = new ArrayList<>();    // 결과리스트
            PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));    // 우선순위 큐 => 시작 시간을 기준으로 오름차순 정렬

            for (String[] plan : plans) {    // 입력배열 순회
                String name = plan[0], time = plan[1], play = plan[2];  // 과목, 시작 시간, 걸리는 시간

                String[] str = time.split(":"); // : 기준으로 문자열 나누기
                int h = Integer.parseInt(str[0]);   // 시
                int m = Integer.parseInt(str[1]);   // 분
                int start = h * 60 + m; // 시작 시간

                int playTime = Integer.parseInt(play);  // 걸리는 시간

                pq.offer(new Task(name, start, playTime));  // 우선순위 큐에 삽입
            }

            Stack<Task> remains = new Stack<>();    // 나머지 과제
            while (!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
                Task now = pq.poll();   // 하나 꺼내어, 현재 과제

                String nowName = now.name;  // 과목
                int nowStart = now.start, nowPlayTime = now.playTime;   // 시작 시간, 걸리는 시간

                int currentTime = nowStart; // 현재 시각
                if (!pq.isEmpty()) { // 새로운 과제가 더 있으면
                    Task next = pq.peek();  // 새로운 과제

                    if (currentTime + nowPlayTime < next.start) {   // 새로운 과제 전까지 끝낼 수 있으면
                        answer.add(nowName);    // 결과리스트에 저장
                        currentTime += nowPlayTime; // 현재 시각 갱신

                        while (!remains.isEmpty()) { // 나머지 과제가 있으면
                            Task remain = remains.pop();    // 최근에 멈춘 과제부터 꺼내어

                            if (currentTime + remain.playTime <= next.start) {   // 새로운 과제 전까지 끝낼 수 있으면
                                answer.add(remain.name);    // 결과리스트에 저장
                                currentTime += remain.playTime; // 현재 시각 갱신
                            } else {    // 없으면
                                int remainTime = remain.playTime - (next.start - currentTime);  // 남는 시간
                                remains.push(new Task(remain.name, remainTime));    // 나머지 과제 스택에 저장
                                break;  // while 종료
                            }
                        }
                    } else if (currentTime + nowPlayTime == next.start) {   // 딱 맞춰 끝내면
                        answer.add(nowName);    // 결과리스트에 저장
                    } else {    // 끝내지 못하면
                        int remainTime = nowPlayTime - (next.start - currentTime);  // 남는 시간
                        remains.push(new Task(nowName, remainTime));    // 나머지 과제 스택에 저장
                    }
                } else {    // 새로운 과제가 없으면
                    if (!remains.isEmpty()) { // 남아있는 과제가 있으면
                        answer.add(nowName);    // 현재 과제 저장 후

                        while (!remains.isEmpty()) { // 나머지 과제가 있는 동안
                            Task remain = remains.pop();    // 하나씩 꺼내서 => 최근에 멈춘 과제부터
                            answer.add(remain.name);    // 결과리스트에 저장
                        }
                    } else {    // 남아있는 과제가 없으면
                        currentTime += nowPlayTime; // 현재 시각 갱신
                        answer.add(nowName);    // 현재 과제 저장
                    }
                }
            }


            return answer.stream().toArray(String[]::new);    // 리스트를 배열로 변환 후 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
    }
}
