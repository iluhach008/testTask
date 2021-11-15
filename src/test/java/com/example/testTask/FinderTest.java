package com.example.testTask;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.testTask.entity.Member;
import com.example.testTask.entity.MembersGroup;
import com.example.testTask.service.Finder;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class FinderTest {

    @Autowired
    private Finder.FinderOldMan finderOldMan;

    @Test
    public void findOldMembers() throws Exception {
        List<MembersGroup> groups = new ArrayList<>();

        List<Member> members1 = new ArrayList<>();
        List<Member> members2 = new ArrayList<>();

        Member member1 = new Member();
        member1.setAge(10);
        member1.setName("1");
        Member member2 = new Member();
        member2.setAge(60);
        member2.setName("2");
        members1.add(member1);
        members1.add(member2);

        Member member3 = new Member();
        member3.setAge(10);
        member3.setName("3");
        Member member4 = new Member();
        member4.setAge(60);
        member4.setName("4");
        members2.add(member3);
        members2.add(member4);

        MembersGroup membersGroup1 = new MembersGroup();
        membersGroup1.setMembers(members1);

        MembersGroup membersGroup2 = new MembersGroup();
        membersGroup2.setMembers(members2);

        groups.add(membersGroup1);
        groups.add(membersGroup2);

        Set<String> test = new HashSet<String>();
        test.add("2");
        test.add("4");

        assertThat(finderOldMan.findOldMembers(groups)).isEqualTo(test);
    }
}
