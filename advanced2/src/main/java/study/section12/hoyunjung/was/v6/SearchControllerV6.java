package study.section12.hoyunjung.was.v6;

import study.section11.hoyunjung.was.httpserver.HttpRequest;
import study.section11.hoyunjung.was.httpserver.HttpResponse;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");

        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
