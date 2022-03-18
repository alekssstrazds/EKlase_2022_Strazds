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
        if(nationality != null) {
            this.nationality = nationality;
        } else this.nationality = Nationality.LATVIAN;
    }
    //Constructor
    Child() {
        super();
        setAlergies("None");
        setPriorityForSpeachLessons(0);
        setNationality(Nationality.LATVIAN);
    }
    Child(String name, String surname, String personalCode, String alergies, int priorityForSpeachLessons, Nationality nationality) {
        super(name, surname, personalCode);
        setAlergies(alergies);
        setPriorityForSpeachLessons(priorityForSpeachLessons);
        setNationality(nationality);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + alergies + " " + nationality + " " + priorityForSpeachLessons;
    }
}
