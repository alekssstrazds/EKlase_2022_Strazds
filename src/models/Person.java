package models;

public class Person {
    //Mainīgie
    private String name;
    private String surname;
    private String personalCode;
    //get funkcijas
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    } 
    public String getPersonalCode() {
        return personalCode;
    }
    //set funkcijas
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }
    //Constructor
    Person() {
        setName("None");
        setSurname("None");
        setPersonalCode("070380-21655");
    }
    Person(String name, String surname, String personalCode) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
    }
    //toString funkcija
    public String toString() {
        return name + " " + surname + " "  + personalCode;
    }
}
