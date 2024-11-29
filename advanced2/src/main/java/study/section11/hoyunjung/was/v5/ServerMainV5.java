package study.section11.hoyunjung.was.v5;

import study.section11.hoyunjung.was.httpserver.HttpServer;
import study.section11.hoyunjung.was.httpserver.ServletManager;
import study.section11.hoyunjung.was.httpserver.servlet.DiscardServlet;

import java.io.IOException;

public class ServerMainV5 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.add("/", new HomeServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2", new Site2Servlet());
        servletManager.add("/search", new SearchServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
