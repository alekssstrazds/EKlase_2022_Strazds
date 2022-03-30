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
    public Integer getPriorityForSpeachLessons() {
        return priorityForSpeachLessons;
    }
    public Nationality getNationality() {
        return nationality;
    }
    //Set funkcijas
    public void setAlergies(String alergies) {
        if(alergies != null && alergies.matches("[;A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[\\s\\da-zēūīļķģšāžčņA-ZĒŪĪĀŠĢĶĻŅČŽ]+")) {
            this.alergies = alergies;
        } else this.alergies = "NoAllergies";
    }
    public void setPriorityForSpeachLessons(int priorityForSpeachLessons) {
        if(priorityForSpeachLessons >= 1 && priorityForSpeachLessons <= 6) {
            this.priorityForSpeachLessons = priorityForSpeachLessons;
        } else this.priorityForSpeachLessons = 6; 
    }
    public void setNationality(Nationality nationality) {
        if(nationality != null) {
            this.nationality = nationality;
        } else this.nationality = Nationality.LATVIAN;
    }
    //Constructor
    public Child() {
        super();
        setAlergies(" ");
        setPriorityForSpeachLessons(6);
        setNationality(Nationality.LATVIAN);
    }
    public Child(String name, String surname, String personalCode, String alergies, int priorityForSpeachLessons, Nationality nationality) {
        super(name, surname, personalCode);
        setAlergies(alergies);
        setPriorityForSpeachLessons(priorityForSpeachLessons);
        setNationality(nationality);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + " " + alergies + " " + priorityForSpeachLessons + " " + nationality;
    }
}
