package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Address;
import model.Person;
import persistence.PersonPersistFactory;
import persistence.PersonDAO;


public class CreateServlet extends BaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonDAO persistenceManager = PersonPersistFactory.getPersonDAO(persistenceMechanism);
        Person user = generatePersonFromRequest(request);
        if (user != null && persistenceManager.createPerson(user)) {
            request.setAttribute("user", user);
            request.setAttribute("message", "ha sido creado con éxito");
            gotoURL(successForm, request, response);
        } else {
            gotoURL(errorForm, request, response);
        }
    }

    Person generatePersonFromRequest(HttpServletRequest request) throws NumberFormatException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("telephone");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        int num = Integer.parseInt(number);
        String town = request.getParameter("town");
        String province = request.getParameter("province");
        
        
        
        Address address = new Address(street, num, town, province);
        
        Person user = new Person(firstName, lastName, telephone, address);

        return user;
    }
}
