package study.section14.hoyunjung.was.v8;

import study.section11.hoyunjung.was.httpserver.HttpResponse;
import study.section14.hoyunjung.was.servlet.Mapping;

public class SiteControllerV8 {

    @Mapping("/")
    public void home(HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site2'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>검색</a></li>");
        response.writeBody("</ul>");
    }

    @Mapping("/site1")
    public void site1(HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }

    @Mapping("/site2")
    public void site2(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

//    경로 중복 등록 확인용
//    @Mapping("/site2")
//    public void page2(HttpResponse response) {
//        response.writeBody("<h1>page2</h1>");
//    }
}
