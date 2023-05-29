package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;

public class DeleteServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        String name = request.getParameter("name");
        Person person = persistenceManager.readPerson(name);
        if (person != null && persistenceManager.deletePerson(name)) {
            request.setAttribute("person", person);
            request.setAttribute("message", "ha sido borrado con éxito");
            gotoURL(successForm, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
