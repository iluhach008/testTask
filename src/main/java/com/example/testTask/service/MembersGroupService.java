package com.example.testTask.service;

import com.example.testTask.entity.Member;
import com.example.testTask.entity.MembersGroup;
import com.example.testTask.model.MemberModel;
import com.example.testTask.model.MembersGroupModel;
import com.example.testTask.repository.MemberRepository;
import com.example.testTask.repository.MembersGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MembersGroupService {

    @Autowired
    private MembersGroupRepository membersGroupRepository;

    public MembersGroup createMemberGroup(MembersGroup membersGroup){
        return membersGroupRepository.save(membersGroup);
    }

    public List<MembersGroupModel> getAll(){
        Iterable<MembersGroup> members = membersGroupRepository.findAll();
        List<MembersGroupModel> result =
                StreamSupport.stream(members.spliterator(), false)
                        .map(MembersGroupModel::toModel)
                        .collect(Collectors.toList());
        return result;
    }
}
