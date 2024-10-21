package study.section04.hoyunjung.member;

import java.util.List;

public interface MemberRepository {

    void add(Member member);

    List<Member> findAll();
}
