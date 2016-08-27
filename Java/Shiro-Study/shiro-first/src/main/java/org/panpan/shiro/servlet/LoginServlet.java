package org.panpan.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PanPan on 2016-08-27.
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        String errorMsg = null;
        try {
            subject.login(token);

        } catch (UnknownAccountException uae) {
            errorMsg= "用户名错误";
        } catch (IncorrectCredentialsException ice) {
            errorMsg= "密码错误";
        } catch (LockedAccountException lae) {
            errorMsg="账户被锁定";
        } catch (ExcessiveAttemptsException eae) {
            errorMsg="多次尝试";
        } catch (AuthenticationException authenticationException) {
            errorMsg="其他错误异常";
        }
        if(errorMsg!=null) {
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }


    }
}
