package LMS.service.serviceImpl;

import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.Lessonable;

import java.util.ArrayList;
import java.util.List;

public class LessonapleImpl implements Lessonable {
    private GroupableImpl groupable;
    private StudenableImpl studenable;
    private List<Group> groups;

    public LessonapleImpl(GroupableImpl groupable, StudenableImpl studenable) {
        this.groupable = groupable;
        this.studenable = studenable;
    }

    @Override
    public String addNewLesson(String groupName, Lesson lesson) {
        Group group = groupable.getGroupByName(groupName);
        group.getLessons().add(lesson);
        return "Урок успешно добавлен";
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        Lesson lesson = null;
        for (Group group: groups) {
            for (Lesson lessons : group.getLessons()) {
                if (lesson.getLesson().equalsIgnoreCase(lessonName)) {
                    lesson = lessons;
                }
            }
        }
        return lesson;
    }

    @Override
    public List<Lesson> getAllOfTheStudentsLessons(String emailStudent) {
        List<Lesson> lessons = new ArrayList<>();
        for (Group group: groups) {
            for (Student student: group.getStudents()){
                if (student.getEmail().equalsIgnoreCase(emailStudent)){
                    lessons.addAll(group.getLessons());
                }
            }
        }
        return lessons;
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
