package controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;

public class ListServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        //String name = request.getParameter("name");
        ArrayList<Person> users = (ArrayList<Person>) persistenceManager.listPersons();
        if (users != null) {
            request.setAttribute("message", "tienen la siguiente informacion almacenada:");
            request.setAttribute("users", users);
            gotoURL(displayAllForm, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }
}
