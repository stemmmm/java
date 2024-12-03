package study.section14.hoyunjung.was.v7;

import study.section11.hoyunjung.was.httpserver.HttpServer;
import study.section11.hoyunjung.was.httpserver.ServletManager;
import study.section11.hoyunjung.was.httpserver.servlet.DiscardServlet;
import study.section14.hoyunjung.was.servlet.AnnotationServletV1;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(new AnnotationServletV1(controllers));
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
