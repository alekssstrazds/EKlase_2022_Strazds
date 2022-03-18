package models;

import java.util.ArrayList;

public class Group {
    // Mainīgie
    private short groupStartYear;
    private String title;
    private Teacher teacher;
    private static ArrayList<Child> allChildrenInGroup = new ArrayList<>();
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
    public void setAllChildrenInGroup(ArrayList<Child> allChild) {
        Group.allChildrenInGroup = allChild;
    }

    public void setGroupStartYear(short groupStartYear) {
        this.groupStartYear = groupStartYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    // Constructor
    Group() {
        setGroupStartYear((short) 0);
        setTitle("None");
        setTeacher(new Teacher());
    }
    Group(short groupStartYear, String title, Teacher teacher) {
        setGroupStartYear(groupStartYear);
        setTitle(title);
        setTeacher(teacher);
    }
    /*//C - create
    private static boolean addChildInGroup(Child allChild) {
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
