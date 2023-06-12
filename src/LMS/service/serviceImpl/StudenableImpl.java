package LMS.service.serviceImpl;
import LMS.model.Group;
import LMS.model.Student;
import LMS.service.Srudentable;

import java.util.ArrayList;
import java.util.List;

public class StudenableImpl  implements Srudentable {
    private  GroupableImpl groupable;

    public StudenableImpl(GroupableImpl groupable) {
        this.groupable = groupable;
    }

    @Override
    public String addNewStudentToGroup(String groupName, Student student) {
        Group group = groupable.getGroupByName(groupName);
        group.getStudents().add(student);
        return "Студент успешно добавлен";
    }

    @Override
    public Student getStudentByFirstName(String firstNameStudent) {
        Student student = null;
        for (Group group: groupable.getGroup()) {
            for (Student students: group.getStudents()) {
                if (students.getFirstName().equalsIgnoreCase(firstNameStudent) || students.getFirstName().contains(firstNameStudent)) {
                    student = students;
                }
            }
        }
        return student;
    }

    @Override
    public Student searchByEmailStudent(String emailStudent) {
        Student student = null;
        for (Group group: groupable.getGroup()) {
            for (Student student1 : group.getStudents()) {
                if (student1.getEmail().equalsIgnoreCase(emailStudent)) {
                    student = student1;
                }
            }
        }
        return student;
    }

    @Override
    public List<Student> getAllStudentByGroupName(String groupName) {
        Group groupByName = groupable.getGroupByName(groupName);
        return groupByName.getStudents();
    }

    @Override
    public Student updateStudent(String oldEmail, Student student) {
        Student student2 = searchByEmailStudent(oldEmail);
        student2.setFirstName(student.getFirstName());
        student2.setLastName(student.getLastName());
        student2.setEmail(student.getEmail());
        student2.setPassword(student.getPassword());
        student2.setGender(student.getGender());
        return student2;
    }

    @Override
    public String deleteStudent(String nameGroup, String emailStudent) {
        Group group = groupable.getGroupByName(nameGroup);
        group.getStudents().remove(searchByEmailStudent(emailStudent));
        return "Студент успешно удален";
    }
}
