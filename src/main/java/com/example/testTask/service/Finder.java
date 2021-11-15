package com.example.testTask.service;

import com.example.testTask.entity.Member;
import com.example.testTask.entity.MembersGroup;
import com.example.testTask.model.MembersGroupModel;
import com.example.testTask.repository.MembersGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Finder {
    public static interface OldMemberFinder {
        public Set<String> findOldMembers(List<MembersGroup> listMembers);
    }

    @Service
    public static class FinderOldMan implements OldMemberFinder {

        @Autowired
        private MembersGroupRepository membersGroupRepository;

        public Set<String> findOldMembers(List<MembersGroup> groups) {
            Set<String> groupsNames = new HashSet<>();
            groups.stream().forEach(membersGroup ->
                    membersGroup.getMembers().stream().filter(member ->
                            member.getAge()>50).map(Member::getName).forEach(groupsNames::add)
            );
            return groupsNames;
        }

        public Set<String> getOldMembers(){
            Iterable<MembersGroup> members = membersGroupRepository.findAll();
            List<MembersGroup> result =
                    StreamSupport.stream(members.spliterator(), false)
                            .collect(Collectors.toList());
            return findOldMembers(result);
        }
    }

}
