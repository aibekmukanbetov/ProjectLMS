package LMS.service.serviceImpl;

import LMS.model.Group;
import LMS.model.Lesson;
import LMS.model.Student;
import LMS.service.Groupable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GroupableImpl implements Groupable {
   private List<Group> groups = new ArrayList<>();

    public List<Group> getGroup() {
        return groups;
    }

    public void setGroup(List<Group> groups) {
        this.groups = groups;
    }
    @Override
    public String addNewGroup(Group group) {
        try {
            for (Group group1: groups){
                if (group1.getNameGroup().equals(group.getNameGroup())){
                    throw new RuntimeException("Группа с тиким названием уже существует");
                }
            }
            groups.add(group);
        } catch (RuntimeException r){
            return r.getMessage();
        }
        return "Группа успешно добавлен";
    }

    @Override
    public Group getGroupByName(String nameGroup) {
        try {
            for (Group group : groups) {
                if (group.getNameGroup().equalsIgnoreCase(nameGroup)) {
                    return group;
                }
            }
            throw new RuntimeException("Группа с таким названием не найдена");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        return null;
    }
    }

    @Override
    public Group updateGroup(String oldGroupName, String newName) {
        Group group = getGroupByName(oldGroupName);
        try {
           for(Group group1: groups){
                if (group1.getNameGroup().equals(newName)){
                   throw new RuntimeException("Группа с таким названием уже существует");
               }
           }
            group.setNameGroup(newName);
            return group;
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
            return null;
        }
    }

    @Override
    public List<Group> getAllGroup() {
        return groups;
    }

    @Override
    public String deleteGroup(String nameGroup) {
        groups.remove(getGroupByName(nameGroup));
        return "Группа успешно удален";
    }
}
