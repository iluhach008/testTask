package com.example.testTask.service;

import com.example.testTask.entity.Member;
import com.example.testTask.entity.MembersGroup;
import com.example.testTask.model.MemberModel;
import com.example.testTask.repository.MemberRepository;
import com.example.testTask.repository.MembersGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MembersGroupRepository membersGroupRepository;

    public Member createMember(Long groupID, Member member){
        MembersGroup group = membersGroupRepository.findById(groupID).get();
        member.setMembersGroup(group);
        return memberRepository.save(member);
    }

    public List<MemberModel> getAll(){
        Iterable<Member> members = memberRepository.findAll();
        List<MemberModel> result =
                StreamSupport.stream(members.spliterator(), false)
                        .map(MemberModel::toModel)
                        .collect(Collectors.toList());
        return result;
    }
}
