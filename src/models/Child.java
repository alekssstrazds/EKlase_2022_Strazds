package models;

public class Child extends Person {
    //Mainīgie
    private String alergies;
    private int priorityForSpeachLessons;
    private Nationality nationality;
    //Get funkcijas
    public String getAlergies() {
        return alergies;
    }
    public int getPriorityForSpeachLessons() {
        return priorityForSpeachLessons;
    }
    public Nationality getNationality() {
        return nationality;
    }
    //Set funkcijas
    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }
    public void setPriorityForSpeachLessons(int priorityForSpeachLessons) {
        this.priorityForSpeachLessons = priorityForSpeachLessons;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
    //Constructor
    Child() {
        setName("None");
        setSurname("None");
        setPersonalCode("None");
        setAlergies("None");
        setPriorityForSpeachLessons(0);
        setNationality(nationality);
    }
    Child(String name, String surname, String personalCode, String alergies, int priorityForSpeachLessons, Nationality nationality) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
        setAlergies(alergies);
        setPriorityForSpeachLessons(priorityForSpeachLessons);
        setNationality(nationality);
    }
    //toString funkcija
    @Override
    public String toString() {
        return "Child [alergies=" + alergies + ", nationality=" + nationality + ", priorityForSpeachLessons=" + priorityForSpeachLessons + "]";
    }
}
