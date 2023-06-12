package LMS.model;

public class Lesson {
    private static long counter = 1;
    private Long id;
    private String lesson;
    private String description;
    private Group group;

    public Lesson(String lesson, String description) {
        this.id = counter++;
        this.lesson = lesson;
        this.description = description;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Lesson.counter = counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nid: " + id +
                ", lesson: " + lesson +
                ", description: " + description;
    }
}
