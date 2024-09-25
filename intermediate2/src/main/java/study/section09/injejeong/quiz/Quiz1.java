package study.section09.injejeong.quiz;

import java.util.HashMap;
import java.util.Map;

// 2차원 배열의 데이터를 Map<String, Integer> 로 변경 후 출력
public class Quiz1 {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
        Map<String, Integer> productMap = new HashMap<>();

        for (String[] product : productArr) {
            productMap.put(product[0], Integer.valueOf(product[1]));
        }

        for (String key : productMap.keySet()) {
            System.out.println("제품: " + key + ", 가격: " + productMap.get(key));
        }
    }
}