package LMS.service;

import LMS.model.Group;

import java.util.List;

public interface Groupable {
    String addNewGroup(Group group);
    Group getGroupByName(String nameGroup);
    Group updateGroup(String oldGroupName, String newName);
    List<Group> getAllGroup();
    String deleteGroup(String nameGroup);

/*    void addGroup(Group group);
    Group getGroupByName(String name);
    List<Group> getAllGroups();
    void removeGroup(Group group);
    void updateGroup(Group group);*/
}
