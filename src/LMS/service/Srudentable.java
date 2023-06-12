package LMS.service;

import LMS.model.Student;

import java.util.List;

public interface Srudentable {
    String addNewStudentToGroup(String groupName, Student student);
    Student getStudentByFirstName(String firstNameStudent);
    Student searchByEmailStudent(String emailStudent);
    List<Student> getAllStudentByGroupName(String groupName);
    Student updateStudent(String oldNameStudent, Student student);
    String deleteStudent(String nameGroup, String emailStudent);

/*    void addStudentToGroup(Student student, Group group);
    Student getStudentByName(String name);
    List<Student> getAllStudentsByGroupName(String groupName);
    void removeStudentByEmail(String email);
    void updateStudent(Student student);*/
}
