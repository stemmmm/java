package study.section13.hoyunjung.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Team {

    @NotEmpty(message = "이름이 비어있습니다.")
    private String name;

    @Range(min = 1, max = 999, message = "회원수는 1과 999사이여야 합니다.")
    private int memberCount;
}
