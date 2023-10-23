package commons;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class ScriptUtil {
    public static void alertError(HttpServletResponse resp,Exception e) throws IOException { //반복되는 부분이므로 따로 빼서 관리
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>",e.getMessage());
        e.printStackTrace();
    }

    public static void go(HttpServletResponse resp, String url, String target) throws IOException{ //target: 이동할 창
        target = Objects.requireNonNullElse(target,"self");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out =  resp.getWriter();
        out.printf("<script>%s.location.replace('%s')</script>",target,url);
        //replace는 history 기록이 남지 않기 때문에 데이터가 중복으로 등록되는 것을 방지할 수 있다.
    }

    public static void go(HttpServletResponse resp, String url) throws IOException{
        go(resp,url, null);
    }
}
