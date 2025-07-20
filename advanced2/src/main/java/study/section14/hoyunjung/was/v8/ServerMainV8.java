package study.section14.hoyunjung.was.v8;

import study.section11.hoyunjung.was.httpserver.HttpServer;
import study.section11.hoyunjung.was.httpserver.ServletManager;
import study.section11.hoyunjung.was.httpserver.servlet.DiscardServlet;
import study.section14.hoyunjung.was.servlet.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class ServerMainV8 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV8(), new SearchControllerV8());

        ServletManager servletManager = new ServletManager();
//        servletManager.setDefaultServlet(new AnnotationServletV2(controllers));
        servletManager.setDefaultServlet(new AnnotationServletV3(controllers));
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
