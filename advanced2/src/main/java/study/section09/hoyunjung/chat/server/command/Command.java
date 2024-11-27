package study.section09.hoyunjung.chat.server.command;

import study.section09.hoyunjung.chat.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
