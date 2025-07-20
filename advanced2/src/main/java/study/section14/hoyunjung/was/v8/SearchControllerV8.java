package study.section14.hoyunjung.was.v8;

import study.section11.hoyunjung.was.httpserver.HttpRequest;
import study.section11.hoyunjung.was.httpserver.HttpResponse;
import study.section14.hoyunjung.was.servlet.Mapping;

public class SearchControllerV8 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");

        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
