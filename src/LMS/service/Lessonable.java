package LMS.service;

import LMS.model.Lesson;
import LMS.model.Student;

import java.util.List;

public interface Lessonable {
    String addNewLesson(String groupName, Lesson lesson);
    Lesson getLessonByName(String lessonName);
    List<Lesson> getAllOfTheStudentsLessons(String emailStudent);
    List<Lesson> getAllLessonByGroupName(String groupName);
    String deleteLesson(String nameGroup, String lessonName);


/*    void addLessonToGroup(Lesson lesson, Group group);
    Lesson getLessonByName(String name);
    List<Lesson> getAllLessonsByStudentEmail(String email);
    List<Lesson> getAllLessonsByGroupName(String groupName);
    void removeLesson(Lesson lesson);*/
}
