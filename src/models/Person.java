package models;

public class Person {
    private String name;
    private String surname;
    private String personalCode;
    /**
     * getName() funckija.
     * @return String tipa vērtība.
     */
    public String getName() {
        return name;
    }
    /**
     * getSurname() funkcija
     * @return String tipa vērtība.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * getPersonalCode() funkcija.
     * @return String tipa vērtība.
     */
    public String getPersonalCode() {
        return personalCode;
    }
    /**
     * Ievieto name mainīgo ievērojot nosacijumu un regex koda nosacijumus.
     * @param name
     */
    public void setName(String name) {
        if(name != null && name.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+\\s?([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+)?")) {
            this.name = name;
        } else this.name = "NoName";
    }
    /**
     *  Ievieto surname mainīgo ievērojot nosacijumu un regex koda nosacijumus.
     * @param surname
     */
    public void setSurname(String surname) {
        if(surname != null && surname.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+[-]?([A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[a-zēūīļķģšāžčņ]+)?")) {
            this.surname = surname;
        } else this.surname = "NoSurname";
    }
    /**
     * Ievieto personalCode mainīgo ievērojot nosacijumu un regex koda nosacijumus.
     * @param personalCode
     */
    public void setPersonalCode(String personalCode) {
        if(personalCode != null && personalCode.matches("[0-9]{6}[-][0-9]{5}")) {
            this.personalCode = personalCode;
        } else this.personalCode = "NoPersonalCode"; 
    }
    //Constructor
    public Person() {
        setName("");
        setSurname("");
        setPersonalCode("");
    }
    public Person(String name, String surname, String personalCode) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
    }
    //toString funkcija
    public String toString() {
        return name + " " + surname + " " + personalCode;
    }
}
