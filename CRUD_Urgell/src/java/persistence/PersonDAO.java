package persistence;

import java.util.List;
import model.Person;


public interface PersonDAO {
    public boolean createPerson(Person person);
    
    public boolean deletePerson(String name);
    
    public Person readPerson(String name);
    
    public List<Person> listPersons();
    
    public boolean updatePerson(String name, Person person);
    
    public boolean checkLogin(String name);

    public boolean setUp(String url, String driver, String user, String password);

    public boolean disconnect();
}
