import java.util.*;
import java.io.*;

/*
Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow
 */

public class 생태학_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        Map<String, Integer> hashMap = new HashMap<>(); // 해시맵

        int count = 0;  // 개수
        String str = "";    // 입력문자열

        while((str = bf.readLine()) != null) {  // null 아니면
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1); // 해시맵 저장
            count++;    // 개수 카운트
        }

        List<String> list = new ArrayList<>(hashMap.keySet());  // 키 값으로 리스트 구현

        Collections.sort(list); // 정렬

        for(String key : list)  // 리스트 순회
            System.out.println(key + " " + String.format("%.4f", (double) hashMap.get(key) / count * 100)); // 결과값 출력
    }
}