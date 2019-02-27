package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.model.UsersSplitwise;
import splitwise.hu.repository.GroupRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    protected GroupService() {}


    public GroupService(GroupRepository groupRepository)
    {
        this.groupRepository = groupRepository;
    }

    public List<GroupSplitwise> getAllGroups() {
        List<GroupSplitwise> allGroup = new ArrayList<>();
        groupRepository.findAll().forEach(allGroup::add);
        return allGroup;
    }

    public void saveAllGroups(List<GroupSplitwise> allGroups) {
        groupRepository.saveAll(allGroups);
    }

    public Optional<GroupSplitwise> getGroupById(long id)
    {
        return groupRepository.findById(id);
    }

    public void addGroup(GroupSplitwise user)
    {
        groupRepository.save(user);
    }

    public void deleteGroup(long id) {
        groupRepository.deleteById(id);
    }

    public void updateGroupById(long id, GroupSplitwise group) {
        GroupSplitwise groupSplitwise=groupRepository.findById(id).get();
        groupSplitwise.setGroupName(group.getGroupName());
    }
}