package study.section04.hoyunjung.member;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private String id;
    private String name;
    private Integer age;
}
