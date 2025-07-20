package study.section08.hoyunjung.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 동시성 처리
 *
 * @author 정호윤
 * @since 2024-10-23
 */
public class SessionManagerV6 {

    private final List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 sessionV6) {
        sessions.add(sessionV6);
    }

    public synchronized void remove(SessionV6 sessionV6) {
        sessions.remove(sessionV6);
    }

    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
