package persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;

public class PersonDAOFileImplementation implements PersonDAO {

    private Map<String, Person> personMap = new HashMap<String, Person>();
    private String fileName;
    private static PersonDAOFileImplementation persistenceManager = null;

    private PersonDAOFileImplementation() {
    }

    public static PersonDAO getFilePersistenceManager() {
        if (persistenceManager == null) {
            persistenceManager = new PersonDAOFileImplementation();
        }
        return persistenceManager;
    }

    @Override
    public boolean setUp(String url, String driver, String user, String password) {
        this.fileName = url;
        try {
            File file = new File(fileName);
            System.out.println(file.getAbsolutePath());
            if (!file.exists()) {
                return true;
            }
            InputStream inputStream = new FileInputStream(file);
            

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            int numberOfPersons = (Integer) objectInputStream.readObject();
            for (int i = 0; i < numberOfPersons; i++) {
                Person person = (Person) objectInputStream.readObject();
                personMap.put(person.getFirstName()+" "+person.getLastName(), person);
            }
            objectInputStream.close();
        } catch (Exception ex) {
            Logger.getLogger(PersonDAOFileImplementation.class.getName()).log(Level.SEVERE,
                    "No se pudieron cargar los datos del archivo", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        try {
            OutputStream outputStream = new FileOutputStream(new File(fileName));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(personMap.size());
            for (Person person : personMap.values()) {
                objectOutputStream.writeObject(person);
            }
            objectOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonDAOFileImplementation.class.getName()).log(Level.SEVERE,
                    "No se pudieron guardar los datos en el archivo", ex);
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean createPerson(Person person) {
        if (personMap.containsKey(person.getFirstName()+" "+person.getLastName())) {
            return false;
        } else {
            personMap.put(person.getFirstName()+" "+person.getLastName(), person);
            return true;
        }
    }

    @Override
    public synchronized boolean deletePerson(String name) {
        if (!personMap.containsKey(name)) {
            return false;
        } else {
            personMap.remove(name);
            return true;
        }
    }

    @Override
    public synchronized boolean updatePerson(String name, Person person) {
        if (!personMap.containsKey(name)) {
            return false;
        } else {
            personMap.put(person.getFirstName()+" "+person.getLastName(), person);
            return true;
        }
    }

    @Override
    public synchronized Person readPerson(String name) {
        return personMap.get(name);
    }
    
    @Override
    public synchronized ArrayList<Person> listPersons(){
        ArrayList<Person> persons = new ArrayList<>(personMap.values());
       return persons;
    }
    
    @Override
    public synchronized boolean checkLogin(String name) {
        if (personMap.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }
}
