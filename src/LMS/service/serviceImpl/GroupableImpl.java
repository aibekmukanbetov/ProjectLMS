package LMS.service.serviceImpl;

import LMS.model.Group;
import LMS.service.Groupable;

import java.util.ArrayList;
import java.util.List;

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
        groups.add(group);
        return "Группа успешно добавлен";
    }

    @Override
    public Group getGroupByName(String nameGroup) {
        Group group1 = null;
        for (Group group: groups) {
            if(group.getNameGroup().equalsIgnoreCase(nameGroup) || group.getNameGroup().contains(nameGroup)){
                group1 = group;
            }
        }
        return group1;
    }

    @Override
    public Group updateGroup(String oldGroupName, String newName) {
        Group group = getGroupByName(oldGroupName);
        group.setNameGroup(newName);
        return group;
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
