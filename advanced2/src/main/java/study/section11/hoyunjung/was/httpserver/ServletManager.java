package study.section11.hoyunjung.was.httpserver;

import lombok.NoArgsConstructor;
import lombok.Setter;
import study.section11.hoyunjung.was.httpserver.servlet.InternalErrorServlet;
import study.section11.hoyunjung.was.httpserver.servlet.NotFoundServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class ServletManager {

    private final Map<String, HttpServlet> servletMap = new HashMap<>();

    @Setter
    private HttpServlet defaultServlet;

    @Setter
    private HttpServlet notFoundErrorServlet = new NotFoundServlet();

    @Setter
    private HttpServlet internalErrorServlet = new InternalErrorServlet();

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            if (servlet == null) {
                throw new PageNotFoundException("request url= " + request.getPath());
            }
            servlet.service(request, response);
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            notFoundErrorServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
        }
    }
}
