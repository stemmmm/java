package study.section07.hoyunjung;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        // InetAddress 클래스를 사용해 호스트 이름으로 대상 IP 찾을 수 있음
        // 시스템 호스트 파일(/etc/hosts) 조회 --없으면-> DNS 서버에 요청
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println(google);
    }
}
