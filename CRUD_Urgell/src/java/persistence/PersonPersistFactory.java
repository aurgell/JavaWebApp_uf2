package persistence;
public class PersonPersistFactory {

    public static PersonDAO getPersonDAO(String persistenceMechanism){
        if (persistenceMechanism.equals("file")){
            return PersonDAOFileImplementation.getFilePersistenceManager();
        }
        else{
            return null;
        }
    }
}
