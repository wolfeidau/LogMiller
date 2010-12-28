package au.id.wolfe.logmiller.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * JAX WS service used for testing.
 */
@SOAPBinding(use = SOAPBinding.Use.LITERAL)
@WebService(name = "PersonManager", targetNamespace = "http://logmiller.wolfe.id.au/personmanager")
public interface PersonManager {

    @SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
    @WebMethod
    public Person getPersonByName(String firstName, String lastName);

}
