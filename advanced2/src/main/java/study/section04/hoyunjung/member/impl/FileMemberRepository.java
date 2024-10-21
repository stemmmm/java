package study.section04.hoyunjung.member.impl;

import study.section04.hoyunjung.member.Member;
import study.section04.hoyunjung.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, UTF_8, true))) {
            writer.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH, UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] memberInfo = line.split(DELIMITER);
                members.add(new Member(memberInfo[0], memberInfo[1], Integer.valueOf(memberInfo[2])));
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
