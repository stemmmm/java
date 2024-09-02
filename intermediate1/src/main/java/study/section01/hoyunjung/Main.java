package study.section01.hoyunjung;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

public class Main {
    public static void main(String[] args) {
        User userA = new User(1);
        User userB = new User(1);

        // id 같으므로  true 출력(equals 메서드 오버라이딩 안하면 false 출력)
        System.out.println(userA.equals(userB));
    }
}

@AllArgsConstructor
@Getter
@EqualsAndHashCode
class User {
    private int id;
}