package study.section02.hoyunjung;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        // 콘솔 스트림(자바 시작될 때 자동으로 만들어짐)
        PrintStream printStream = System.out;
        byte[] bytes = "Hello, ".getBytes(StandardCharsets.UTF_8);

        printStream.write(bytes);       // OutputStream의 메서드
        printStream.println("World!");  // PrintStream의 메서드
    }
}
