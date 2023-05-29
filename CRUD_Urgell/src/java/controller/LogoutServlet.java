package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LogoutServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession session = request.getSession();
            session.setAttribute("auth", false);
            response.sendRedirect("/view/main.jsp");

    }
}
