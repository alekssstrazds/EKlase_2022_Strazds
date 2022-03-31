package models;

import java.util.ArrayList;

public class Group {
    private short groupStartYear;
    private String title;
    private Teacher teacher;
    private ArrayList<Child> allChildrenInGroup = new ArrayList<>();
    /**
     * getAllChildrenInGroup() funkcija.
     * @return ArrayList<Child> tipa saraksts.
     */
    public ArrayList<Child> getAllChildrenInGroup() 
    {
        return allChildrenInGroup;
    }
    /**
     * getGroupStartYear() funkcija.
     * @return short tipa vērtība.
     */
    public short getGroupStartYear() {
        return groupStartYear;
    }
    /**
     * getTitle() funkcija.
     * @return String tipa vērtība.
     */
    public String getTitle() {
        return title;
    }
    /**
     * getTeacher() funckija.
     * @return Teacher tipa objekts.
     */
    public Teacher getTeacher() {
        return teacher;
    }
    /**
     * Ievieto visus allChildrenInGroup arraylist objektus.
     * @param allChildrenInGroup
     */
    public void setAllChildrenInGroup(ArrayList<Child> allChildrenInGroup) {
        if(allChildrenInGroup != null) {
            this.allChildrenInGroup = allChildrenInGroup;
        } else this.allChildrenInGroup = new ArrayList<Child>();
    }
    /**
     * Ievieto groupStartYear mainīgā vērtību.
     * @param groupStartYear
     */
    public void setGroupStartYear(short groupStartYear) {
        if(groupStartYear >= 2020 && groupStartYear < 2023) {
            this.groupStartYear = groupStartYear;
        } else this.groupStartYear = 0;
    }
    /**
     * Ievieto title mainīgā vērtību.
     * @param title
     */
    public void setTitle(String title) {
        if(title != null && title.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+\s?([A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+)?")) {
            this.title = title;
        } else this.title = "notknown";
    }
    /**
     * Ievieto teacher objektu.
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        if(teacher != null) {
            this.teacher = teacher;
        } else this.teacher = new Teacher();
    }
    //Constructor
    public Group() {
        setGroupStartYear((short) 0);
        setTitle("");
        setTeacher(new Teacher());
    }
    public Group(short groupStartYear, String title, Teacher teacher) {
        setGroupStartYear(groupStartYear);
        setTitle(title);
        setTeacher(teacher);
    }
    /**
     * Pievieno Child objektu kurš tiek padot, kā parametrs iekšs allChildrenInGroup arraylist.
     * @param child
     * @return
     */
    public boolean addChildrenInGroup(Child child) {
        if(allChildrenInGroup.contains(child)) {
            return false;
        } else if(child != null) {
            allChildrenInGroup.add(child);
        } return true;
    }
    /**
     * Tiek dzēsts padotais Child objekts no allChildrenInGroup arraylist.
     * @param child
     * @return
     */
    public boolean removeChildInGroup(Child child) {
        if(allChildrenInGroup.contains(child)) {
            allChildrenInGroup.remove(child);
            return true;
        }
        return true;
    }
    //toString funckija
    public String toString() {
        return groupStartYear + " " + title + " " + teacher;
    }
    
}
