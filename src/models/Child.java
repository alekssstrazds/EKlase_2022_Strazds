package models;

public class Child extends Person {
    private String alergies;
    private int priorityForSpeachLessons;
    private Nationality nationality;
    /**
     * getAlergies() funckija.
     * @return String tipa vērtību.
     */
    public String getAlergies() {
        return alergies;
    }
    /**
     * getPriorityForSpeachLessons() funkcija.
     * @return Integer tipa vērtība.
     */
    public Integer getPriorityForSpeachLessons() {
        return priorityForSpeachLessons;
    }
    /**
     * getNationality() funkcija.
     * @return enum klases vērtības.
     */
    public Nationality getNationality() {
        return nationality;
    }
    /**
     * Ievieto alergies mainīgā vērtību.
     * @param alergies
     */
    public void setAlergies(String alergies) {
        if(alergies != null && alergies.matches("[;A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[\\s\\da-zēūīļķģšāžčņA-ZĒŪĪĀŠĢĶĻŅČŽ]+")) {
            this.alergies = alergies;
        } else this.alergies = "NoAllergies";
    }
    /**
     * Ievieto priorityForSpeachLessons mainīgā vērtību.
     * @param priorityForSpeachLessons
     */
    public void setPriorityForSpeachLessons(int priorityForSpeachLessons) {
        if(priorityForSpeachLessons >= 1 && priorityForSpeachLessons <= 6) {
            this.priorityForSpeachLessons = priorityForSpeachLessons;
        } else this.priorityForSpeachLessons = 6; 
    }
    /**
     * Ievieto nationality enum vērtību.
     * @param nationality
     */
    public void setNationality(Nationality nationality) {
        if(nationality != null) {
            this.nationality = nationality;
        } else this.nationality = Nationality.LATVIAN;
    }
    //Constructor
    public Child() {
        super();
        setAlergies("");
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
