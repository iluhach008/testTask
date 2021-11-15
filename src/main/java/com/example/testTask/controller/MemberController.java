package com.example.testTask.controller;

import com.example.testTask.entity.Member;
import com.example.testTask.repository.MemberRepository;
import com.example.testTask.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity addMember(@RequestParam Long groupID, @RequestBody Member member){
        try {
            return ResponseEntity.ok(memberService.createMember(groupID, member));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping
    public ResponseEntity getMembers() {
        try {
            return ResponseEntity.ok(memberService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
