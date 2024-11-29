package study.section11.hoyunjung.was.v5;

import study.section11.hoyunjung.was.httpserver.HttpRequest;
import study.section11.hoyunjung.was.httpserver.HttpResponse;
import study.section11.hoyunjung.was.httpserver.HttpServlet;

import java.io.IOException;

public class SearchServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getParameter("q");

        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
