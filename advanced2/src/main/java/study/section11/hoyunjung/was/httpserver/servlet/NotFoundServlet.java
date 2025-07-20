package study.section11.hoyunjung.was.httpserver.servlet;

import study.section11.hoyunjung.was.httpserver.HttpRequest;
import study.section11.hoyunjung.was.httpserver.HttpResponse;
import study.section11.hoyunjung.was.httpserver.HttpServlet;

import java.io.IOException;

public class NotFoundServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(404);
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다.</h1>");
    }
}
