package models;

import java.util.ArrayList;

public class Group {
    // Mainīgie
    private short groupStartYear;
    private String title;
    private Teacher teacher;
    private ArrayList<Child> allChildrenInGroup = new ArrayList<>();
    // Get funkcijas
    public ArrayList<Child> getAllChildrenInGroup() 
    {
        return allChildrenInGroup;
    }
    public short getGroupStartYear() {
        return groupStartYear;
    }
    public String getTitle() {
        return title;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    // Set funkcijas
    public void setAllChildrenInGroup(ArrayList<Child> allChildrenInGroup) {
        if(allChildrenInGroup != null) {
            this.allChildrenInGroup = allChildrenInGroup;
        } else this.allChildrenInGroup = new ArrayList<Child>();
    }
    public void setGroupStartYear(short groupStartYear) {
        if(groupStartYear >= 2020 && groupStartYear < 2023) {
            this.groupStartYear = groupStartYear;
        } else this.groupStartYear = 0;
    }
    public void setTitle(String title) {
        if(title != null && title.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+\s?([A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+)?")) {
            this.title = title;
        } else this.title = "notknown";
    }
    public void setTeacher(Teacher teacher) {
        if(teacher != null) {
            this.teacher = teacher;
        } else this.teacher = new Teacher();
    }
    // Constructor
    public Group() {
        setGroupStartYear((short) 0);
        setTitle("No Title");
        setTeacher(new Teacher());
    }
    public Group(short groupStartYear, String title, Teacher teacher) {
        setGroupStartYear(groupStartYear);
        setTitle(title);
        setTeacher(teacher);
    }
    public boolean addChildInGroup(Child child) {
        if(allChildrenInGroup.contains(child)) {
            return false;
        } else allChildrenInGroup.add(child);
        return true;
    }
    public boolean removeChildInGroup(Child child) {
        if(allChildrenInGroup.contains(child)) {
            allChildrenInGroup.remove(child);
            return true;
        }
        return true;
    }
    //toString funckija
    public String toString() {
        return groupStartYear + " " + title;
    }
    
}
