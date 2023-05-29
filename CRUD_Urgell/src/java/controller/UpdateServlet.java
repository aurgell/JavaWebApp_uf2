package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;

public class UpdateServlet extends CreateServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        String formerName = request.getParameter("formerName");
        Person person = super.generatePersonFromRequest(request);
        if (persistenceManager.updatePerson(formerName, person)) {
            request.setAttribute("person", person);
            request.setAttribute("message", "ha sido modificada con éxito");
            gotoURL(successForm, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
