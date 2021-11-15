package com.example.testTask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class MembersGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membersGroup")
    private List<Member> members;
}
