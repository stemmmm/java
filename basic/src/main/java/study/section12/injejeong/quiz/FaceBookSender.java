package study.section12.injejeong.quiz;

import study.week2.section12.injejeong.quiz.Sender;

public class FaceBookSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("페이스북에 발송합니다: " + message);
    }
}
