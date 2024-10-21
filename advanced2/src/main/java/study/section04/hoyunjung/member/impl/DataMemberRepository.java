package study.section04.hoyunjung.member.impl;

import study.section04.hoyunjung.member.Member;
import study.section04.hoyunjung.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            out.writeUTF(member.getId());   // 2바이트 추가 사용해 길이도 같이 저장하여, 읽어올 때 저장된 길이만큼 읽어옴
            out.writeUTF(member.getName());
            out.writeInt(member.getAge());  // Integer 타입은 4바이트이므로, 읽어올 때 4바이트만큼 읽어옴
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (in.available() > 0) {
                members.add(new Member(in.readUTF(), in.readUTF(), in.readInt()));
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
