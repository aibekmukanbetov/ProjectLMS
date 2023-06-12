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
        try {
            for (Student student1: group.getStudents()) {
                if (student1.getEmail().equals(student.getEmail())){
                    throw new RuntimeException("Студент с таким логином уже существует");
                }
            }
            group.getStudents().add(student);
        } catch (RuntimeException r){
            return (r.getMessage());
        }
        return "Студент успешно добавлен";
    }

    @Override
    public Student getStudentByFirstName(String firstNameStudent) {
        try{
            for (Group group: groupable.getGroup()) {
                for (Student students: group.getStudents()) {
                    if (students.getFirstName().equalsIgnoreCase(firstNameStudent) || students.getFirstName().contains(firstNameStudent)) {
                        return students;
                    }
                }
            }
            throw new RuntimeException("Студент с таким именем не найден");
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
            return null;
        }
    }

    @Override
    public Student searchByEmailStudent(String emailStudent) {
        try {
            for (Group group: groupable.getGroup()) {
                for (Student student : group.getStudents()) {
                    if (student.getEmail().equalsIgnoreCase(emailStudent)) {
                        return student;
                    }
                }
            }
            throw new RuntimeException("Студент с таким логинов не найден");
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
            return null;
        }

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
