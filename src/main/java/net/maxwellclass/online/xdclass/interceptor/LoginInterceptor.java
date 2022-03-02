package net.maxwellclass.online.xdclass.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import net.maxwellclass.online.xdclass.utils.JWTUtils;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description:登录拦截器
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/26 13:52
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }
            if (StringUtils.isNoneBlank(accessToken)) {
                Claims claims = JWTUtils.checkJWT(accessToken);
                if (claims == null) {
                    //告诉登录失败，重新登陆
                    sendJSonMessage(response, JsonData.buildError("登录过期！重新登陆！!"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendJSonMessage(response,JsonData.buildError("请先登录!"));
        return false;
    }

    /**
     * 登录过期,未登录返回JSON信息
     * @param response
     * @param obj
     */
    public static void sendJSonMessage(HttpServletResponse response, Object obj) {

        try(PrintWriter writer = response.getWriter())
        {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            writer.print(objectMapper.writeValueAsString(obj));
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
