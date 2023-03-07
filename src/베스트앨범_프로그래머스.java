import java.util.*;

public class 베스트앨범_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500})));
    }

    public static class Solution {

        public class Music {   // 클래스
            // 멤버 변수
            String genre;
            int plays;
            int index;

            // 멤버 함수
            public Music(String genre, int plays, int index) {  // 생성자
                this.genre = genre;
                this.plays = plays;
                this.index = index;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> map = new HashMap<>(); // 해시맵

            for(int i = 0; i < genres.length; i++) // 길이만큼
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);  // 구현

            List<String> orderedGenres = new ArrayList<>(); // 리스트
            while(map.size() != 0) {    // 크기만큼
                int max = 0;    // 최대값 구하기
                String maxGenre = "";   // 최대값을 가지는 장르

                for(String str : map.keySet()) {    // 순회
                    int now = map.get(str); // 키 값 하나 꺼내어
                    if(now > max) { // 크면
                        max = now;  // 최대값
                        maxGenre = str; // 장르 설정
                    }
                }

                orderedGenres.add(maxGenre);    // 재생횟수 내림차순
                map.remove(maxGenre);   // 삭제
            }

            List<Music> result = new ArrayList<>(); // 결과 리스트
            for(String str : orderedGenres) {   // 리스트 순회
                List<Music> arr = new ArrayList<>();
                for(int i = 0; i < genres.length; i++)  // 길이만큼
                    if(genres[i].equals(str))   // 같으면
                        arr.add(new Music(str, plays[i], i));   // 객체 생성 후 리스트에 삽입

                Collections.sort(arr, (o1, o2) -> (o2.plays - o1.plays));   // 내림차순

                result.add(arr.get(0)); // 최대값 하나 삽입, 하나 이상이므로
                if(arr.size() != 1) // 1개보다 크면
                    result.add(arr.get(1)); // 하나 더 삽입, 2개까지 삽입하므로
            }

            int len = result.size();    // 결과리스트 크기
            int[] answer = new int[len];    // 크기만큼 배열 생성
            for(int i = 0; i < len; i++)    // 순회
                answer[i] = result.get(i).index;    // 해당 리스트의 인덱스 저장

            return answer;  // 배열 리턴
        }
    }
}
