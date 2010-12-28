package au.id.wolfe.logmiller.cxf.service;

import javax.jws.WebService;
import java.util.Date;

/**
 *
 */
@WebService(name = "PersonManager", serviceName = "PersonManagerService", portName = "PersonManagerPort",
    targetNamespace = "http://logmiller.wolfe.id.au/personmanager",
    endpointInterface = "au.id.wolfe.logmiller.cxf.service.PersonManager")
public class PersonManagerImpl implements PersonManager {

    public Person getPersonByName(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        person.setDateOfBirth(new Date());
        return person;
    }
}
