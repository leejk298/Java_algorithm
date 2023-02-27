import java.util.*;

public class 호텔대실_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    static class Booking {
        int start, end;

        public Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Solution {
        List<Booking> bList = new ArrayList<>();

        public int getTime(String t) {
            String[] str = t.split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            return h * 60 + m;
        }

        public int solution(String[][] book_time) {

            for(String[] t : book_time) {
                int s = getTime(t[0]);
                int e = getTime(t[1]);

                bList.add(new Booking(s, e));
            }

            Collections.sort(bList, (o1, o2) -> {
                if(o1.start == o2.start)
                    return o1.end - o2.end;

                return o1.start - o2.start;
            });

            List<Integer> endTime = new ArrayList<>();

            for(Booking b : bList) {
                boolean flag = false;

                for(int i = 0; i < endTime.size(); i++) {
                    int endT = endTime.get(i) + 10;
                    if(b.start >= endT) {
                        endTime.set(i, b.end);
                        flag = true;

                        break;
                    }
                }

                if(!flag)
                    endTime.add(b.end);

                Collections.sort(endTime);
            }

            return endTime.size();
        }
    }
}
