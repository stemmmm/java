package study.section12.injejeong.quiz;

import study.week2.section12.injejeong.quiz.Sender;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다: " + message);
    }
}
