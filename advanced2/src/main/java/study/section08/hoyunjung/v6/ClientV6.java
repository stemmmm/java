package study.section08.hoyunjung.v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static study.util.MyLogger.log;

/**
 * ClientV5와 동일
 *
 * @author 정호윤
 * @since 2024-10-23
 */
public class ClientV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        log("클라이언트 시작");

        // 선언한 순서의 반대인 output -> input -> socket 순으로 close() 호출
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            log("소켓 연결: " + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("전송 문자: ");
                String toSend = scanner.nextLine();

                // 서버에게 문자 보내기
                output.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equals("exit")) break;

                // 서버로부터 문자 받기
                String received = input.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        }
    }
}
