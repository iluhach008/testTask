package com.example.testTask.model;

import com.example.testTask.entity.Member;
import com.example.testTask.entity.MembersGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MembersGroupModel {
    private Long id;
    private String name;
    private List<MemberModel> members;

    public static MembersGroupModel toModel(MembersGroup entity) {
        MembersGroupModel model = new MembersGroupModel();
        model.setId(entity.getId());
        model.setName(entity.getGroupName());
        model.setMembers(entity.getMembers().stream().map(MemberModel::toModel).collect(Collectors.toList()));
        return model;
    }
}
