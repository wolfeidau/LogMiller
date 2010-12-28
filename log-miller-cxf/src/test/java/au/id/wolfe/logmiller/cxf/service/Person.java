package au.id.wolfe.logmiller.cxf.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

/**
 *
 */
public class Person {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("firstName", firstName).
                append("lastName", lastName).
                append("dateOfBirth", dateOfBirth).
                toString();
    }
}
