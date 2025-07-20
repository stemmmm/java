package study.section09.hoyunjung.chat.server.command;

import study.section09.hoyunjung.chat.server.Session;
import study.section09.hoyunjung.chat.server.SessionManager;

import java.io.IOException;

public class ChangeCommand implements Command {

    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String changedName = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + changedName + "로 이름을 변경했습니다.");
        session.setUsername(changedName);
    }
}
