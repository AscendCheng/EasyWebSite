package com.website.video.interceptor;

import com.google.gson.Gson;
import com.website.video.utils.JsonResult;
import com.website.video.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }
        if (token != null) {
            Claims claims = JwtUtils.checkJwt(token);
            Integer userId = (Integer) claims.get("id");
            String name = (String) claims.get("name");
            request.setAttribute("user_id", userId);
            request.setAttribute("user_name", name);
            return true;
        }
        sendMessage(response, JsonResult.fail("请登录！"));
        return false;
    }

    private static void sendMessage(HttpServletResponse response, Object object) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(object));
        printWriter.flush();
    }
}
