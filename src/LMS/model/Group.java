package LMS.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private static long counter = 1;
    private Long id;
    private String nameGroup;
    private  String description;
    private List<Lesson> lessons = new ArrayList<>();
    private  List<Student> students = new ArrayList<>();
    public Group(String nameGroup, String description) {
        this.id = counter++;
        this.nameGroup = nameGroup;
        this.description = description;
    }

    public Group(String nameGroup, String description, List<Lesson> lessons, List<Student> students) {
        this.nameGroup = nameGroup;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {

        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nGroup  " +
                "\nid: " + id +
                "\nnameGroup: " + nameGroup +
                "\ndescription: " + description +
                "\nlessons: " + lessons +
                "\nstudents: " + students;
    }
}
