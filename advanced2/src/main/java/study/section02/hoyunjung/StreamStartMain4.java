package study.section02.hoyunjung;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] readBytes = fis.readAllBytes();  // 모든 바이트 한 번에 읽기
        System.out.println(Arrays.toString(readBytes));
        fis.close();
    }
}
