package study.section12.injejeong.quiz;

import study.week2.section12.injejeong.quiz.Sender;

public class EmailSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("메일을 발송합니다: " + message);
    }
}
