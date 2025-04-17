package study.section07.hoyunjung.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static study.util.MyLogger.log;

/**
 * 여러 클라이언트 동시 접속 가능
 *
 * @author 정호윤
 * @since 2024-10-22
 */
public class ServerV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();  // 블로킹
            log("소켓 연결: " + socket);

            SessionV3 session = new SessionV3(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
