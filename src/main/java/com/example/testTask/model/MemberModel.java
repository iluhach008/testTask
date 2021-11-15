package com.example.testTask.model;

import com.example.testTask.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberModel {
    private Long id;
    private String name;
    private Integer age;

    public static MemberModel toModel(Member member){
        MemberModel model = new MemberModel();
        model.setId(member.getId());
        model.setAge(member.getAge());
        model.setName(member.getName());
        return model;
    }
}
