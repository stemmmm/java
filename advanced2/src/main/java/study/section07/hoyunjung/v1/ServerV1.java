package study.section07.hoyunjung.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static study.util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        // 서버에서 포트를 열어두어야 클라이언트가 해당 포트에 접속할 수 있음
        // 1. 서버가 12345 포트로 서버 소켓 열어둠
        // 2. 클라이언트가 12345 포트에 연결 시도(TCP 3-way handshake)
        // 3. TCP 연결이 완료되면 서버는 운영체제의 backlog queue에 클라이언트-서버의 TCP 연결 정보(IP, 포트 정보) 보관
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // ServerSocket은 클라이언트-서버 TCP 연결만 지원하는 특별한 소켓임
        // accept() 메서드를 호출하면, backlog queue의 TCP 연결 정보로 Socket 객체를 생성하고 해당 연결 정보는 queue에서 제거됨
        // 만약 backlog queue에 TCP 연결 정보가 없다면, 연결 정보가 생성될 때까지 대기함(블로킹)
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // 클라이언트로부터 문자 받기
        String received = input.readUTF();
        log("client -> server: " + received);

        // 클라이언트에게 문자 보내기
        String toSend = received + " World!";
        output.writeUTF(toSend);
        log("cliend <- server: " + toSend);

        // 자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
