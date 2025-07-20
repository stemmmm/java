package study.section08.hoyunjung.v5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static study.util.MyLogger.log;

/**
 * ServerV3, V4와 동일
 *
 * @author 정호윤
 * @since 2024-10-23
 */
public class ServerV5 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();  // 블로킹
            log("소켓 연결: " + socket);

            SessionV5 session = new SessionV5(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
