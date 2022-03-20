package models;

import java.util.ArrayList;

public class Group {
    // Mainīgie
    private short groupStartYear;
    private String title;
    private Teacher teacher;
    private ArrayList<Child> allChildrenInGroup = new ArrayList<>();
    // Get funkcijas
    public ArrayList<Child> getAllChildrenInGroup() {
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
        if(title != null && title.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽ]{1}[\\s\\da-zēūīļķģšāžčņA-ZĒŪĪĀŠĢĶĻŅČŽ]+")) {
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
        setTitle("None");
        setTeacher(new Teacher());
    }
    public Group(short groupStartYear, String title, Teacher teacher) {
        setGroupStartYear(groupStartYear);
        setTitle(title);
        setTeacher(teacher);
    }
    //C - create
    /*private static boolean addChildInGroup(Child allChild) {
        allChild = new Child();
        if(allChild.contains(allChild)) {
            return false;
        } else allCourses.add(course);
        return true;
    }
    //D - delete
    private static boolean removeChildInGroup(Child person) {
        if(courseId >= 1000 & courseId < 10000) {
            for (Course course : allCourses) {
                if(course.getId() == courseId) {
                    allCourses.remove(course);
                    return true;
                }
            }
        }
        return false;
    }*/
    //toString funckija
    public String toString() {
        return groupStartYear + " " + title;
    }
    
}
