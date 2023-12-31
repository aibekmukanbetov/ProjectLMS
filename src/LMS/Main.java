package LMS;

import LMS.enumuration.Gender;
import LMS.model.Admin;
import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.serviceImpl.GroupableImpl;
import LMS.service.serviceImpl.LessonapleImpl;
import LMS.service.serviceImpl.StudenableImpl;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroupableImpl groupable = new GroupableImpl();
        StudenableImpl studenable = new StudenableImpl(groupable);
        LessonapleImpl lessonaple = new LessonapleImpl(groupable, studenable);
        Admin admin = new Admin();
        int choice;
        do {
            Main.hour();
            System.out.println("1. Для входа");
            System.out.println("2. Если вы забыли пароль");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    try {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Введите email: ");
                        String adminEmail = scanner1.nextLine();
                        System.out.println("Введите пароль: ");
                        String passwordAdmin = scanner1.nextLine();
                        if(!admin.getEmail().equals(adminEmail) || !admin.getPassword().equals(passwordAdmin)){
                            throw new RuntimeException("Не правильный email или пароль");
                        } else {
                            int num;
                            do {
                                System.out.println(
                                        "|_______________________________________________________________________|\n" +
                                        "| 1.Add new group                 | 9.Get all student by group name     |\n" +
                                        "| 2.Get group by name             | 10.Update student                   |\n" +
                                        "| 3.Update group name             | 11.Delete student                   |\n" +
                                        "| 4.Get all group                 | 12.Add new lesson to group          |\n" +
                                        "| 5.Delete group by name          | 13.Get Lesson by name               |\n" +
                                        "| 6.Add new student to group      | 14.Get all of the student's lessons |\n" +
                                        "| 7.Get student by first name     | 15.Get all of the group's lessons   |\n" +
                                        "| 8.Get student by email          | 16.Delete lesson                    |\n" +
                                        "|                           17 Exit                                     |\n" +
                                        "|_______________________________________________________________________|\n");
                                Scanner scanner21 = new Scanner(System.in);
                                num = scanner21.nextInt();
                                switch (num){
                                    case 1:
                                        Scanner scanner22 = new Scanner(System.in);
                                        System.out.println("Введите название группы: ");
                                        String nameGroup= scanner22.nextLine();
                                        System.out.println("Введите направление группы: ");
                                        String descriptionGroup = scanner22.nextLine();
                                        System.out.println(groupable.addNewGroup(new Group(nameGroup, descriptionGroup)));
                                        break;
                                    case 2:
                                        Scanner scanner2 = new Scanner(System.in);
                                        System.out.println("Для поиска введите название группы: ");
                                        String groupName=scanner2.nextLine();
                                        System.out.println(groupable.getGroupByName(groupName));
                                        break;
                                    case 3:
                                        Scanner scanner3 = new Scanner(System.in);
                                        System.out.println("Введите название группы которую хотите измменить: ");
                                        String oldGroupName = scanner3.nextLine();
                                        System.out.println("Введите новое название группы: ");
                                        String newGroupName = scanner3.nextLine();
                                        System.out.println(groupable.updateGroup(oldGroupName, newGroupName));
                                        break;
                                    case 4:
                                        System.out.println(groupable.getAllGroup());
                                        break;
                                    case 5:
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Введите названи группы для удаления: ");
                                        String group = scanner4.nextLine();
                                        System.out.println(groupable.deleteGroup(group));
                                        break;
                                    case 6:
                                        Scanner scanner5 = new Scanner(System.in);
                                        System.out.println("Введите название группы куда вы хотите добавить: ");
                                        String nameG = scanner5.nextLine();
                                        System.out.println("Введите имя студента: ");
                                        String firstName = scanner5.nextLine();
                                        System.out.println("Введите фамилию студента: ");
                                        Scanner scanner6 = new Scanner(System.in);
                                        String lastName = scanner6.nextLine();
                                        System.out.println("Введите электронную почту студента: ");
                                        String emailStudent = scanner6.nextLine();
                                        System.out.println("Введите пароль студента: ");
                                        Scanner scanner7 = new Scanner(System.in);
                                        String password = scanner7.nextLine();
                                        System.out.println("Введите пол студента: ");
                                        String genderInput = scanner7.next();
                                        Gender gender = Gender.valueOf(genderInput.toUpperCase());
                                        System.out.println(studenable.addNewStudentToGroup(nameG, new Student(firstName, lastName, emailStudent, password, gender )));
                                        break;
                                    case 7:
                                        Scanner scanner8 = new Scanner(System.in);
                                        System.out.println("Для поискаа Введите имя студента: ");
                                        String nameStudent = scanner8.nextLine();
                                        System.out.println(studenable.getStudentByFirstName(nameStudent));
                                        break;
                                    case 8:
                                        Scanner scanner9 = new Scanner(System.in);
                                        System.out.println("Введите электронную почту студента: ");
                                        String studentEmail = scanner9.nextLine();
                                        System.out.println(studenable.searchByEmailStudent(studentEmail));
                                        break;
                                    case 9:
                                        Scanner scanner10 = new Scanner(System.in);
                                        System.out.println("Введите название группы: ");
                                        String gName = scanner10.nextLine();
                                        System.out.println(studenable.getAllStudentByGroupName(gName));
                                        break;
                                    case 10:
                                        Scanner scanner11 = new Scanner(System.in);
                                        System.out.println("Введите почту студента которого хотите изменить: ");
                                        String email = scanner11.nextLine();
                                        System.out.println("Введите новое имя студента: ");
                                        String newFirstName =scanner11.nextLine();
                                        System.out.println("Введите новую фамилию студента: ");
                                        Scanner scanner12 = new Scanner(System.in);
                                        String newLastName = scanner12.nextLine();
                                        System.out.println("Введите новую электронную почту студента: ");
                                        String newEmailSudent = scanner12.nextLine();
                                        System.out.println("Введите новый пароль: ");
                                        Scanner scanner13 = new Scanner(System.in);
                                        String newPassword = scanner13.nextLine();
                                        System.out.println("Введите пол студента: ");
                                        String neGender = scanner13.nextLine();
                                        Gender newGender = Gender.valueOf(neGender.toUpperCase());
                                        System.out.println(studenable.updateStudent(email, new Student(newFirstName, newLastName, newEmailSudent, newPassword, newGender)));
                                        break;
                                    case 11:
                                        System.out.println("Введите название группы: ");
                                        Scanner scanner14 = new Scanner(System.in);
                                        String nameGr = scanner14.nextLine();
                                        System.out.println("Введите электронную почту студента которого хотите удалить: ");
                                        String studentEmailDelete = scanner14.nextLine();
                                        System.out.println(studenable.deleteStudent(nameGr, studentEmailDelete));
                                        break;
                                    case 12:
                                        System.out.println("Введите название группы: ");
                                        Scanner scanner15 = new Scanner(System.in);
                                        String GrName = scanner15.nextLine();
                                        System.out.println("Введите название урока: ");
                                        Scanner scanner16 = new Scanner(System.in);
                                        String lesson = scanner16.nextLine();
                                        System.out.println("Введите описание урока: ");
                                        String lessonDescription = scanner16.nextLine();
                                        System.out.println(lessonaple.addNewLesson(GrName, new Lesson(lesson, lessonDescription)));
                                        break;
                                    case 13:
                                        System.out.println("Введите название урока: ");
                                        Scanner scanner17 = new Scanner(System.in);
                                        String lessonName = scanner17.nextLine();
                                        System.out.println(lessonaple.getLessonByName(lessonName));
                                        break;
                                    case 14:
                                        System.out.println("Введите электронную почту студента: ");
                                        Scanner scanner18 = new Scanner(System.in);
                                        String emailStud = scanner18.nextLine();
                                        System.out.println(lessonaple.getAllOfTheStudentsLessons(emailStud));
                                        break;
                                    case 15:
                                        System.out.println("Введите название группы: ");
                                        Scanner scanner19 = new Scanner(System.in);
                                        String nameGrou = scanner19.nextLine();
                                        System.out.println(lessonaple.getAllLessonByGroupName(nameGrou));
                                        break;
                                    case 16:
                                        System.out.println("Введите название группы: ");
                                        Scanner scanner20 = new Scanner(System.in);
                                        String groName = scanner20.nextLine();
                                        System.out.println("Введите название урока которую котите удалить: ");
                                        String nameLesson = scanner20.nextLine();
                                        System.out.println(lessonaple.deleteLesson(groName, nameLesson));
                                        break;
                                    case 17:
                                        System.out.println("EXIT");
                                        break;
                                    default:
                                        System.out.println("Не выбран номер, пожалуйста попробуйте снова");
                                }
                            } while (num !=17);
                        }
                    } catch (RuntimeException r){
                        System.out.println(r.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Введите email для изменения пароля: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String emailAdmin = scanner1.nextLine();
                    System.out.println("Введите новый пароль: ");
                    String newPassword = scanner1.nextLine();
                    System.out.println(admin.updateAdminPassword(emailAdmin, newPassword));
                    break;
            }
        }while (choice!=3);




    }


    public static void  hour(){
        String formattedTime = ZonedDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        if (ZonedDateTime.now().getHour()>=8 && ZonedDateTime.now().getHour()<12) {
            System.out.println("Доброе утро! Время: " + formattedTime);
        } else if (ZonedDateTime.now().getHour()>=12 && ZonedDateTime.now().getHour()<18) {
            System.out.println("Добрый день! Время: " + formattedTime);
        } else if (ZonedDateTime.now().getHour()>=18 && ZonedDateTime.now().getHour()<22) {
            System.out.println("Добрый вечер! Время: " + formattedTime);
        } else {
            System.out.println("Доброй ночи! Время: " + formattedTime);
        }
    }
}
