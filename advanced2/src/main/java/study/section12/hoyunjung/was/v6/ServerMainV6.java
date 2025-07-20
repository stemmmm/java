package study.section12.hoyunjung.was.v6;

import study.section11.hoyunjung.was.httpserver.HttpServer;
import study.section11.hoyunjung.was.httpserver.ServletManager;
import study.section11.hoyunjung.was.httpserver.servlet.DiscardServlet;
import study.section11.hoyunjung.was.v5.HomeServlet;
import study.section12.hoyunjung.was.httpserver.ReflectionServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV6(), new SearchControllerV6());

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(new ReflectionServlet(controllers));
        servletManager.add("/", new HomeServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
