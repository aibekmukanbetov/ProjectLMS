package LMS.service.serviceImpl;

import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.Lessonable;

import java.util.ArrayList;
import java.util.List;

public class LessonapleImpl implements Lessonable {
    private GroupableImpl groupable;
    private StudenableImpl studentable;


    public LessonapleImpl(GroupableImpl groupable, StudenableImpl studenable) {
        this.groupable = groupable;
        this.studentable = studenable;
    }

    @Override
    public String addNewLesson(String groupName, Lesson lesson) {
        Group group = groupable.getGroupByName(groupName);
        try {
            for (Lesson lesson1: group.getLessons()) {
                if (lesson1.getLesson().equals(lesson.getLesson())){
                    throw new RuntimeException("Студент с таким логином уже существует");
                }
            }
            group.getLessons().add(lesson);
        } catch (RuntimeException r){
            return (r.getMessage());
        }
        return "Урок успешно добавлен";
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        try{
            for (Group group: groupable.getGroup()) {
                for (Lesson lessons : group.getLessons()) {
                    if (lessons.getLesson().equalsIgnoreCase(lessonName)) {
                        return lessons;
                    }
                }
            }
            throw  new RuntimeException("Урок с таким название не найден");
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
            return null;
        }
    }

    @Override
    public List<Lesson> getAllOfTheStudentsLessons(String emailStudent) {
        List<Lesson> lessons = new ArrayList<>();
        try {
            for (Group group: groupable.getGroup()) {
                for (Student student: group.getStudents()){
                    if (student.getEmail().equalsIgnoreCase(emailStudent)){
                        lessons.addAll(group.getLessons());
                        return lessons;
                    }
                }
            }
             throw new RuntimeException("Студент с таким логином не найден");
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
            return null;
        }

    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        Group group = groupable.getGroupByName(groupName);
        return group.getLessons();
    }

    @Override
    public String deleteLesson(String nameGroup, String lessonName) {
        Group group = groupable.getGroupByName(nameGroup);
       group.getLessons().remove(getLessonByName(lessonName));
        return "Урок успешно удален";
    }
}
