package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Address;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;


public class LoginServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        String name = request.getParameter("firstName")+ " "+request.getParameter("lastName");
        if (name != null && persistenceManager.checkLogin(name)) {         
            
            HttpSession session = request.getSession();
            session.setAttribute("auth", persistenceManager.checkLogin(name));
            response.sendRedirect("/view/main.jsp");
            
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
