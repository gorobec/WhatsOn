package model;

/**
 * Created by gorobec on 29.01.16.
 */
public class Person {
    private String lastnameOrigin;
    private String lastname;
    private String firstnameOrigin;
    private String firstname;

    public Person(String lastnameOrigin, String lastname, String firstnameOrigin, String firstname) {
        this.lastnameOrigin = lastnameOrigin;
        this.lastname = lastname;
        this.firstnameOrigin = firstnameOrigin;
        this.firstname = firstname;
    }

    public String getLastnameOrigin() {
        return lastnameOrigin;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstnameOrigin() {
        return firstnameOrigin;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!lastnameOrigin.equals(person.lastnameOrigin)) return false;
        if (!lastname.equals(person.lastname)) return false;
        if (!firstnameOrigin.equals(person.firstnameOrigin)) return false;
        return firstname.equals(person.firstname);

    }

    @Override
    public int hashCode() {
        int result = lastnameOrigin.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + firstnameOrigin.hashCode();
        result = 31 * result + firstname.hashCode();
        return result;
    }
}
