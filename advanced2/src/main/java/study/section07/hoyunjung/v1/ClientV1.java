package study.section07.hoyunjung.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static study.util.MyLogger.log;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        // 1. 내부적으로 InetAddress를 사용해 localhost를 127.0.0.1로 매핑
        // 2. 127.0.0.1:12345에 TCP 접속 시도(클라이언트 포트는 내부적으로 랜덤 할당)
        // 3. 연결 완료되면 Socket 객체 반환
        Socket socket = new Socket("localhost", PORT);

        // 클라이언트-서버 통신을 위해 소켓이 제공하는 스트림 사용
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        // 서버에게 문자 보내기
        String toSend = "Hello";
        output.writeUTF(toSend);
        log("client -> server: " + toSend);

        // 서버로부터 문자 받기
        String received = input.readUTF();
        log("client <- server: " + received);

        // 자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
