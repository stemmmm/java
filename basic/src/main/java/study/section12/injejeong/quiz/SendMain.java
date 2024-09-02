package study.section12.injejeong.quiz;

public class SendMain {
    public static void main(String[] args) {
        // 한번에 여러 곳에 메시지를 발송하는 프로그램
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};
        for (Sender sender : senders) {
            sender.sendMessage("환영합니다!");
        }
    }
}