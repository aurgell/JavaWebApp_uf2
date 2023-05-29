package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;

public class ReadServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        String name = request.getParameter("name");
        Person user = persistenceManager.readPerson(name);
        if (user != null) {
            request.setAttribute("message", "tienen la siguiente informacion almacenada:");
            request.setAttribute("user", user);
            gotoURL(displayForm, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
