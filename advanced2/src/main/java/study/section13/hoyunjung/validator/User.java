package study.section13.hoyunjung.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    @NotEmpty(message = "이름이 비어있습니다.")
    private String name;

    @Range(min = 1, max = 100, message = "나이는 1과 100사이여야 합니다.")
    private int age;
}
