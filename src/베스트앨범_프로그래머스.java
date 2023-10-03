import java.util.*;

public class 베스트앨범_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500})));
    }

    public static class Solution {
        public class Music {    // 음악 클래스
            // 매개변수
            String genre;   // 장르
            int plays, index;   // 재생수, 인덱스 => 인덱스 출력 필요하므로

            public Music(String genre, int plays, int index) {  // 파라미터 생성자
                this.genre = genre;
                this.plays = plays;
                this.index = index;
            }
        }

        public int[] solution(String[] genres, int[] plays) {

            Map<String, Integer> hashMap = new HashMap<>(); // 해시맵
            for(int i = 0; i < genres.length; i++)  // 크기만큼
                hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);  // 장르별로 저장

            List<String> orderedGenres = new ArrayList<>(); // 장르별 재생 수 내림차순 정렬 리스트
            while(hashMap.size() != 0) {    // 해시맵이 존재하면 반복
                int max = 0;    // 최대 재생수
                String maxGenre = "";   // 최대 재생 수에 해당하는 장르

                for(String s : hashMap.keySet()) {  // 키 값으로 해시맵 순회
                    int nowPlay = hashMap.get(s);   // 현재 장르에 해당하는 재생 수

                    if(max < nowPlay) { // 최대이면
                        max = nowPlay;  // 갱신
                        maxGenre = s;   // 장르 저장
                    }
                }

                orderedGenres.add(maxGenre);    // 최대 장르부터 저장
                hashMap.remove(maxGenre);   // 최대 장르부터 해시맵에서 삭제
            }

            List<Music> result = new ArrayList<>(); // 결과리스트
            for(String s : orderedGenres) { // 정렬된 장르리스트 순회
                List<Music> list = new ArrayList<>();   // 음악리스트

                for(int i = 0; i < genres.length; i++)  // 크기만큼
                    if(genres[i].equals(s)) // 일치하면
                        list.add(new Music(s, plays[i], i));    // 음악리스트에 해당 장르, 재생수, 인덱스 음악클래스 객체로 저장

                Collections.sort(list, (o1, o2) -> (o2.plays - o1.plays));  // 재생 수 내림차순 정렬

                result.add(list.get(0));    // 제일 많이 재생된 음악을 결과리스트에 저장
                if(list.size() != 1)    // 1개 보다 많으면
                    result.add(list.get(1));    // 하나 더 결과리스트에 저장
            }

            int size = result.size();   // 결과리스트 크기
            int[] answer = new int[size];   // 결과배열 선언

            for(int i = 0; i < size; i++)   // 크기만큼
                answer[i] = result.get(i).index;    // 인덱스 저장

            return answer;  // 결과배열 리턴
        }
    }
}
